package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.repository.PaperRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaperServiceImplTest {
    @Autowired
    private PaperRepository paperService;

    @Test
    public void getAll() {
        System.out.println(paperService.findById("1809.00064"));
    }

    @Test
    void getBytitle() {
        //System.out.println(paperService.findByTitle("Generalizing Procrustes Analysis for Better Bilingual Dictionary Induction"));
        System.out.println(paperService.findByTitleLike("Generalizing Procrustes Analysis for Better Bilin"));
    }

    @Test
    public void getAuthors() {
        System.out.println(paperService.findAuthorsByID("1809.00064"));
    }

    @Test
    public void getTopics() {
        System.out.println(paperService.findTopicByID("1809.00064"));
    }
}