package dblab.bit.backend.services;

import dblab.bit.backend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    private AuthorRepository authorRepository;
/*
    @Test
    public void test() {
        System.out.println(authorRepository.findById("https://dblp.uni-trier.de/pers/hd/l/Luo:Jinquan"));
    }


 */
}