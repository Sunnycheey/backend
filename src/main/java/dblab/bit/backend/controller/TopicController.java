package dblab.bit.backend.controller;

import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.response.BaseCollectionResponse;
import dblab.bit.backend.response.BaseSingleResponse;
import dblab.bit.backend.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: backend
 * @description: Restful controller of topic class
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/static/topics", method = RequestMethod.GET)
    public BaseCollectionResponse getTopics() {
        BaseCollectionResponse<Topic> baseCollectionResponse = new BaseCollectionResponse<>();
        baseCollectionResponse.setData(topicService.getTopicList());
        baseCollectionResponse.setCode(200);
        baseCollectionResponse.setMessage("OK");
        return baseCollectionResponse;
    }

    @RequestMapping(value = "/static/topic/{id}", method = RequestMethod.GET)
    public BaseSingleResponse getTopicsById(@PathVariable long id) {
        BaseSingleResponse<Topic> baseSingleResponse = new BaseSingleResponse<>();
        baseSingleResponse.setData((topicService.getTopicById(id, 1)));
        baseSingleResponse.setCode(200);
        baseSingleResponse.setMessage("OK");
        return baseSingleResponse;
    }
}
