package dblab.bit.backend.controller;

import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.repository.AuthorRepository;
import dblab.bit.backend.response.BaseCollectionResponse;
import dblab.bit.backend.response.BaseSingleResponse;
import dblab.bit.backend.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorService authorService;

    @RequestMapping(path = "/search/authors", method = RequestMethod.GET)
    public BaseCollectionResponse<Author> getAll() {
        BaseCollectionResponse<Author> baseCollectionResponse = new BaseCollectionResponse<>();
        List<Author> authors = authorService.getAll();
        baseCollectionResponse.setSuccessfullyState(authors);
        return baseCollectionResponse;
    }

    @RequestMapping(path = "/search/authors/paper/{id}", method = RequestMethod.GET)
    public BaseCollectionResponse<Paper> getPapersByAuthor(@PathVariable long id) {
        BaseCollectionResponse<Paper> baseCollectionResponse = new BaseCollectionResponse<>();
        List<Paper> papers = authorRepository.getPapersByAuthorId(id);
        baseCollectionResponse.setSuccessfullyState(papers);
        return baseCollectionResponse;
    }

    @RequestMapping(path = "/search/authors/{id}", method = RequestMethod.GET)
    public BaseSingleResponse<Author> getAuthor(@PathVariable long id) {
        BaseSingleResponse<Author> baseSingleResponse = new BaseSingleResponse<>();
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            baseSingleResponse.setSuccessfullyState(author.get());
        } else {
            baseSingleResponse.setSuccessfullyState(null);
        }
        return baseSingleResponse;
    }
}
