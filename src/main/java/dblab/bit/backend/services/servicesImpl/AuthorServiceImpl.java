package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.repository.AuthorRepository;
import dblab.bit.backend.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: backend
 * @description: author service impl
 * @author: lihuichao
 * @create: 2020-05-21
 **/
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        List<Author> ret = new ArrayList<>();
        Iterable<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            ret.add(author);
        }
        return ret;
    }
}
