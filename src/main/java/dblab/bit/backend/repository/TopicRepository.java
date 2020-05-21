package dblab.bit.backend.repository;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Topic;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @program: backend
 * @description: Interface for topic services
 * @author: lihuichao
 * @create: 2020-04-23
 **/
public interface TopicRepository extends CrudRepository<Topic, Long> {
    @Query("match (n:Paper)-[:PaperFieldOfStudy*1]->(g) where id(g)=$0 return n;")
    List<Paper> findPapersByTopic(long id);

    @Query("match (n:Paper)-[:PaperFieldOfStudy*1..$depth]->(g) where id(g)=$id return n;")
    List<Paper> findPapersByTopic(@Param("id") long id, @Param("depth") long depth);
}
