package dblab.bit.backend.repository;

import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.models.NodeEntity.Paper;
import org.springframework.data.neo4j.annotation.Query;

import java.util.List;

/**
 * @program: backend
 * @description: services for author
 * @author: lihuichao
 * @create: 2020-05-20
 **/
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Query("match (n:Paper)-[:WritenBy]->(g) where id(g)=$0 return n;")
    List<Paper> getPapersByAuthorId(long id);
}
