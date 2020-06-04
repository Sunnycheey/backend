package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.interceptor.Auth;
import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.models.NodeEntity.Venue;
import dblab.bit.backend.repository.PaperRepository;
import dblab.bit.backend.repository.TopicRepository;
import dblab.bit.backend.services.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: backend
 * @description: paper service impl
 * @author: lihuichao
 * @create: 2020-05-21
 **/
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperRepository paperRepository;
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<Paper> getAll() {
        Iterable<Paper> papers = paperRepository.findAll();
        List<Paper> paperList = new ArrayList<>();
        for (Paper paper : papers) {
            paperList.add(paper);
        }
        return paperList;
    }

    @Override
    public List<Paper> getPapersIdByTitle(String title) {
        List<Paper> papers = paperRepository.findByTitleLike(title);
        if (papers.isEmpty()) {
            return null;
        }
        return papers;
    }

    @Override
    public List<Paper> getRelatedPapers(String id) {
        List<Topic> topics = paperRepository.findTopicByID(id);
        List<Paper> papers = new ArrayList<>();
        for (Topic topic : topics) {
            papers.addAll(topicRepository.findPapersByTopic(topic.getId()));
        }
        return papers;
    }

    @Override
    public Optional<Paper> getById(String id){
        return paperRepository.findById(id);
    }

    @Override
    public List<Author> getAuthorByPaperId(String id){
        return paperRepository.findAuthorsByID(id);
    }

    @Override
    public List<Topic> getTopicByPaperId(String id){
        return paperRepository.findTopicByID(id);
    }

    @Override
    public List<Venue> getVenueByPaperId(String id){
        return paperRepository.findVenueByID(id);
    }

    @Override
    public Map<String,Object> getPaperPageInfoById(String id){
        Map<String,Object> ans=new HashMap<>();
        Optional<Paper> paperOptional=paperRepository.findById(id);
        if(paperOptional.isPresent()){
            Paper paper=paperOptional.get();
            List<Author> authors=paperRepository.findAuthorsByID(id);
            List<Venue> venues=paperRepository.findVenueByID(id);
            List<Topic> topics=paperRepository.findTopicByID(id);
            ans.put("Paper",paper);
            ans.put("Author",authors);
            ans.put("Topic",topics);
            ans.put("Venue",venues);
        }
        return ans;
    }
}
