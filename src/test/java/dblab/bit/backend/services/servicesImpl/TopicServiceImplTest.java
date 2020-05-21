package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.repository.TopicRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TopicServiceImplTest {

    @Autowired
    private TopicRepository topicService;

    @Test
    public void getPapers() {
        System.out.println(topicService.findPapersByTopic(23591));
    }
}