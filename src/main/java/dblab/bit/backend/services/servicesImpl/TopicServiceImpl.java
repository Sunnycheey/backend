package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.services.TopicService;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @program: backend
 * @description: Implement class for topic service interface
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private SessionFactory sessionFactory;
    private static Session session;

    @PostConstruct
    private void setSession() {
        this.session = sessionFactory.openSession();
    }

    @Override
    public Iterable<Topic> getTopicList() {
        Iterable<Topic> topics = session.loadAll(Topic.class, 0);
        return topics;
    }

    @Override
    public Topic getTopicById(long id, int depth) {
        Topic topic = session.load(Topic.class, id, depth);
        return topic;
    }
}