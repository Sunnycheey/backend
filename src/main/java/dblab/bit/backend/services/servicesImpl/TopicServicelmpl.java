package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.repository.PaperRepository;
import dblab.bit.backend.repository.TopicRepository;
import dblab.bit.backend.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: backend
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-06-02 19:09
 **/

@Service
public class TopicServicelmpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<Paper> getPapersByTopic(long id) {
        return topicRepository.findPapersByTopic(id);
    }

    @Override
    public List<Topic> getTopicByName(String name) {
        return topicRepository.findTopicByName(name);
    }

    @Override
    public Optional<Topic> getById(long id){
        return topicRepository.findById(id);
    }

    @Override
    public List<Topic> getAll(){
        Iterable<Topic>Topics=topicRepository.findAll();
        List<Topic> tmp=new ArrayList<>();
        for(Topic topic:Topics){
            tmp.add(topic);
        }
        return tmp;
    }

    @Override
    public Map<String,Object> getTopicPageInfoById(long id){
        Map<String,Object> ans=new HashMap<>();
        Optional<Topic> topicOptional=topicRepository.findById(id);
        if(topicOptional.isPresent()){
            Topic topic=topicOptional.get();
            List<Paper> papers=topicRepository.findPapersByTopic(id);
            ans.put("Topic",topic);
            ans.put("Paper",papers);
        }
        return ans;
    }

}
