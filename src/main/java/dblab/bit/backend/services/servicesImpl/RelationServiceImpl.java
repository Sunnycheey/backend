package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.models.RelationEntity.RelationOverTopics.ContributeTo;
import dblab.bit.backend.services.RelationService;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @program: backend
 * @description: implement of relation service
 * @author: lihuichao
 * @create: 2020-04-24
 **/
@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void setSession() {
        session = sessionFactory.openSession();
    }


    @Override
    public ContributeTo getContributoById(long id) {
        return session.load(ContributeTo.class, id, 1);
    }
}
