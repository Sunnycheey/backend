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

    //查找作者id的论文
    @Query("match (n:Paper)-[:WritenBy]->(g) where id(g)=$0 return n;")
    List<Paper> findPapersByAuthorId(long id);

    @Query("match (n:Author) where tolower(n.name) contains tolower($0) return n ")
    List<Author> findAuthorByName(String name);

}
