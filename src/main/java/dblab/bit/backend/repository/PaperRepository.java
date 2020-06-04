package dblab.bit.backend.repository;

import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.models.NodeEntity.Venue;
import org.springframework.data.neo4j.annotation.Query;

import java.util.List;

/**
 * @program: backend
 * @description: Interface for paper services
 * @author: lihuichao
 * @create: 2020-04-23
 **/
public interface PaperRepository extends CrudRepository<Paper, String> {

//    List<Paper> findByTitle(String title);

    @Query("match (n:Paper) where tolower(n.title) contains tolower($0) return n;")
    List<Paper> findByTitleLike(String title);

    @Query("match (n:Paper {ID:$0})-[:WritenBy]->(g) return g;")
    List<Author> findAuthorsByID(String id);

    @Query("match (n:Paper {ID:$0})-[:PaperFieldOfStudy]->(g) return g;")
    List<Topic> findTopicByID(String id);

    @Query("match (n:Paper {ID:$0})-[:PublishedBy]->(g) return g")
    List<Venue> findVenueByID(String id);

}
