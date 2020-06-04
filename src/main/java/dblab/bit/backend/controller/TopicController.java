package dblab.bit.backend.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.repository.TopicRepository;
import dblab.bit.backend.response.BaseCollectionResponse;
import dblab.bit.backend.response.BaseMapResponse;
import dblab.bit.backend.response.BaseSingleResponse;
import dblab.bit.backend.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @program: backend
 * @description: Restful controller of topic class
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RestController
public class TopicController {

    @Autowired
    private TopicService topicServicelmpl;

    @RequestMapping(value = "/static/topics", method = RequestMethod.GET)
    public BaseCollectionResponse getTopics() {
        BaseCollectionResponse<Topic> baseCollectionResponse = new BaseCollectionResponse<>();
        baseCollectionResponse.setSuccessfullyState(topicServicelmpl.getAll());
        return baseCollectionResponse;
    }

//    @RequestMapping(value = "/static/topic/id/{id}", method = RequestMethod.GET)
//    public BaseSingleResponse getTopicsById(@PathVariable long id) {
//        BaseSingleResponse<Optional<Topic>> baseSingleResponse = new BaseSingleResponse<>();
//        baseSingleResponse.setData((topicRepository.findById(id, 1)));
//        baseSingleResponse.setCode(200);
//        baseSingleResponse.setMessage("OK");
//        return baseSingleResponse;
//    }

    @RequestMapping(value = "/static/topic/{id}",method = RequestMethod.GET)
    public BaseMapResponse getTopicsById(@PathVariable long id){
        BaseMapResponse baseMapResponse=new BaseMapResponse();
        baseMapResponse.setSuccessfullyState(topicServicelmpl.getTopicPageInfoById(id));
        return baseMapResponse;
    }

    @RequestMapping(value="/search/topic/name/{name}",method=RequestMethod.GET)
    public BaseCollectionResponse<Topic> getTopicByName(@PathVariable String name){
        List<Topic> topics=topicServicelmpl.getTopicByName(name);
        BaseCollectionResponse<Topic> baseCollectionResponse=new BaseCollectionResponse<>();
        baseCollectionResponse.setSuccessfullyState(topics);
        return baseCollectionResponse;
    }


}
