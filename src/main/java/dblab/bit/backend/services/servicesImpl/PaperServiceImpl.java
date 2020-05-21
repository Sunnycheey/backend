package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.repository.PaperRepository;
import dblab.bit.backend.repository.TopicRepository;
import dblab.bit.backend.services.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Paper> papers = paperRepository.findByTitle(title);
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
    public Optional<Paper> getById(String id) {
        return paperRepository.findById(id);
    }
}
