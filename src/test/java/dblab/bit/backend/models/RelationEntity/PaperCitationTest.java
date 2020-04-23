package dblab.bit.backend.models.RelationEntity;

import org.junit.jupiter.api.Test;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaperCitationTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void test() {
        Session neo4jSession = sessionFactory.openSession();
        System.out.println(sessionFactory);
    }
}