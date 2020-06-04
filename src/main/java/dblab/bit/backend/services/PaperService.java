package dblab.bit.backend.services;

import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.models.NodeEntity.Venue;

import java.util.List;
import java.util.Map;
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

    List<Author> getAuthorByPaperId(String id);

    List<Topic> getTopicByPaperId(String id);

    List<Venue> getVenueByPaperId(String id);

    Map<String,Object>getPaperPageInfoById(String id);

}
