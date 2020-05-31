package dblab.bit.backend.services;

import dblab.bit.backend.models.NodeEntity.Paper;

import java.util.List;
import java.util.Optional;

/**
 * @program: backend
 * @description: service for paper class
 * @author: lihuichao
 * @create: 2020-05-21
 **/
public interface PaperService {
    List<Paper> getRelatedPapers(String id);

    List<Paper> getPapersIdByTitle(String title);


    List<Paper> getAll();

    Optional<Paper> getById(String id);
}
