package dblab.bit.backend.services;

import dblab.bit.backend.models.NodeEntity.Author;

import java.util.List;

/**
 * @program: backend
 * @description: author service
 * @author: lihuichao
 * @create: 2020-05-21
 **/
public interface AuthorService {
    List<Author> getAll();
}
