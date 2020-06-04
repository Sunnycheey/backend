package dblab.bit.backend.controller;

import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.repository.AuthorRepository;
import dblab.bit.backend.response.BaseCollectionResponse;
import dblab.bit.backend.response.BaseMapResponse;
import dblab.bit.backend.response.BaseSingleResponse;
import dblab.bit.backend.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @program: backend
 * @description: controller for class author
 * @author: lihuichao
 * @create: 2020-05-21
 **/
@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorServicelmpl;

    @RequestMapping(path = "/search/authors", method = RequestMethod.GET)
    public BaseCollectionResponse<Author> getAll() {
        BaseCollectionResponse<Author> baseCollectionResponse = new BaseCollectionResponse<>();
        List<Author> authors = authorServicelmpl.getAll();
        baseCollectionResponse.setSuccessfullyState(authors);
        return baseCollectionResponse;
    }


    @RequestMapping(path = "/static/authors/{id}", method = RequestMethod.GET)
    public BaseMapResponse getAuthor(@PathVariable long id) {
        BaseMapResponse baseMapResponse = new BaseMapResponse();
        baseMapResponse.setSuccessfullyState(authorServicelmpl.getAuthorPageInfoById(id));
        return baseMapResponse;
    }

    @RequestMapping(path = "/search/authors/{name}", method = RequestMethod.GET)
    public BaseCollectionResponse<Author> getPapersByAuthor(@PathVariable String name) {
        List<Author> authors = authorServicelmpl.getAuthorByName(name);
        BaseCollectionResponse baseCollectionResponse = new BaseCollectionResponse();
        baseCollectionResponse.setSuccessfullyState(authors);
        return baseCollectionResponse;
    }

}

