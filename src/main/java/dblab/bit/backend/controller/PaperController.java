package dblab.bit.backend.controller;

import dblab.bit.backend.interceptor.Auth;
import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.models.NodeEntity.Venue;
import dblab.bit.backend.repository.PaperRepository;
import dblab.bit.backend.response.BaseCollectionResponse;
import dblab.bit.backend.response.BaseMapResponse;
import dblab.bit.backend.response.BaseSingleResponse;
import dblab.bit.backend.services.PaperService;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private PaperService paperServicelmpl;

    @RequestMapping(value = "/search/papers", method = RequestMethod.GET)
    public BaseCollectionResponse<Paper> getAll() {
        List<Paper> papers = paperServicelmpl.getAll();
        BaseCollectionResponse<Paper> paperBaseCollectionResponse = new BaseCollectionResponse<>();
        paperBaseCollectionResponse.setSuccessfullyState(papers);
        return paperBaseCollectionResponse;
    }

    @RequestMapping(value = "/static/papers/{paperId}", method = RequestMethod.GET)
    public BaseMapResponse getPaperById(@PathVariable String paperId) {
        BaseMapResponse baseMapResponse=new BaseMapResponse();
        baseMapResponse.setSuccessfullyState(paperServicelmpl.getPaperPageInfoById(paperId));
        return baseMapResponse;
    }

    @RequestMapping(value = "/search/papers/title/{title}", method = RequestMethod.GET)
    public BaseCollectionResponse<Paper> getPapersByTitle(@PathVariable String title) {
        List<Paper> papers = paperServicelmpl.getPapersIdByTitle(title);
        BaseCollectionResponse<Paper> baseCollectionResponse = new BaseCollectionResponse<>();
        baseCollectionResponse.setSuccessfullyState(papers);
        return baseCollectionResponse;
    }

    @RequestMapping(value = "/search/papers/related/{id}", method = RequestMethod.GET)
    public BaseCollectionResponse<Paper> getRelatedPaperByTitle(@PathVariable String id) {
        List<Paper> papers = paperServicelmpl.getRelatedPapers(id);
        BaseCollectionResponse<Paper> baseCollectionResponse = new BaseCollectionResponse<>();
        baseCollectionResponse.setSuccessfullyState(papers);
        return baseCollectionResponse;
    }
}
