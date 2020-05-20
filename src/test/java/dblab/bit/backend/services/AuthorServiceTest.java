package dblab.bit.backend.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    public void test() {
        System.out.println(authorService.findById("https://dblp.uni-trier.de/pers/hd/l/Luo:Jinquan"));
    }

}