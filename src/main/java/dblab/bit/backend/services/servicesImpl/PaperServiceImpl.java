package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.services.PaperService;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @program: backend
 * @description: Implement class for paper service interface
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private SessionFactory sessionFactory;
    private static Session session;

    @PostConstruct
    private void setSession() {
        this.session = sessionFactory.openSession();
    }

    @Override
    public Iterable<Paper> getPaperList() {
        Iterable<Paper> papers = session.loadAll(Paper.class, 0);
        return null;
    }
}
