package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.services.RelationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RelationServiceImplTest {

    @Autowired
    RelationService relationService;

    @Test
    public void test() {
        System.out.println(relationService.getContributoById(106059));
    }

}