package dblab.bit.backend.controller;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.repository.PaperRepository;
import dblab.bit.backend.response.BaseCollectionResponse;
import dblab.bit.backend.response.BaseSingleResponse;
import dblab.bit.backend.services.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @program: backend
 * @description: Controller for paper class
 * @author: lihuichao
 * @create: 2020-05-21
 **/
@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;
    @Autowired
    private PaperRepository paperRepository;

    @RequestMapping(value = "/search/papers", method = RequestMethod.GET)
    public BaseCollectionResponse<Paper> getAll() {
        List<Paper> papers = paperService.getAll();
        BaseCollectionResponse<Paper> paperBaseCollectionResponse = new BaseCollectionResponse<>();
        paperBaseCollectionResponse.setSuccessfullyState(papers);
        return paperBaseCollectionResponse;
    }

    @RequestMapping(value = "/search/papers/id/{paperId}", method = RequestMethod.GET)
    public BaseSingleResponse<Paper> getPaperById(@PathVariable String paperId) {
        Optional<Paper> paper = paperRepository.findById(paperId);
        BaseSingleResponse<Paper> baseSingleResponse = new BaseSingleResponse<>();
        if (paper.isPresent()) {
            baseSingleResponse.setSuccessfullyState(paper.get());
        } else {
            baseSingleResponse.setSuccessfullyState(null);
        }
        return baseSingleResponse;
    }

    @RequestMapping(value = "/search/papers/title/{title}", method = RequestMethod.GET)
    public BaseCollectionResponse<Paper> getPapersByTitle(@PathVariable String title) {
        List<Paper> papers = paperService.getPapersIdByTitle(title);
        BaseCollectionResponse<Paper> baseCollectionResponse = new BaseCollectionResponse<>();
        baseCollectionResponse.setSuccessfullyState(papers);
        return baseCollectionResponse;
    }

    @RequestMapping(value = "/search/papers/related/{id}", method = RequestMethod.GET)
    public BaseCollectionResponse<Paper> getRelatedPaperByTitle(@PathVariable String id) {
        List<Paper> papers = paperService.getRelatedPapers(id);
        BaseCollectionResponse<Paper> baseCollectionResponse = new BaseCollectionResponse<>();
        baseCollectionResponse.setSuccessfullyState(papers);
        return baseCollectionResponse;
    }
}
