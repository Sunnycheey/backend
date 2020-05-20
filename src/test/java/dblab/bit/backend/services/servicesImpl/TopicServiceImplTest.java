package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.services.TopicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TopicServiceImplTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void getTopics() {
        System.out.println(topicService.getTopicList());
    }

    @Test
    public void getTopic() {
        System.out.println(topicService.getTopicById(16446, 2));
    }
}