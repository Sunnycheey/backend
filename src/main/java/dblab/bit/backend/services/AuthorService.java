package dblab.bit.backend.services;

import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Venue;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @program: backend
 * @description: author service
 * @author: lihuichao
 * @create: 2020-05-21
 **/
public interface AuthorService {
    List<Author> getAll();
    List<Paper> getPapersByAuthorId(long id);
    Optional<Author> getById(long id);
    List<Author> getAuthorByName(String name);
    Map<String,Object> getAuthorPageInfoById(long id);
}
