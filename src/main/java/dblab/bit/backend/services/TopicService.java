package dblab.bit.backend.services;

import dblab.bit.backend.models.NodeEntity.Topic;

/**
 * @program: backend
 * @description: Interface for topic services
 * @author: lihuichao
 * @create: 2020-04-23
 **/
public interface TopicService {
    Iterable<Topic> getTopicList();

    Topic getTopicById(long id, int depth);
}