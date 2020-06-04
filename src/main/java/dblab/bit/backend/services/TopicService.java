package dblab.bit.backend.services;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Topic;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TopicService {
    List<Paper> getPapersByTopic(long id);

    List<Topic> getTopicByName(String name);

    Optional<Topic>  getById(long id);

    List<Topic> getAll();

    Map<String,Object> getTopicPageInfoById(long id);
}
