package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.repository.AuthorRepository;
import dblab.bit.backend.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<Paper> getPapersByAuthorId(long id){
        List<Paper> Papers=authorRepository.findPapersByAuthorId(id);
        return Papers;
    }


    @Override
    public Optional<Author> getById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> getAuthorByName(String name){
        return authorRepository.findAuthorByName(name);
    }


    @Override
    public Map<String,Object>getAuthorPageInfoById(long id){
        Map<String,Object> ans=new HashMap<>();
        Optional<Author> authorOptional=authorRepository.findById(id);
        if(authorOptional.isPresent()){
            Author author=authorOptional.get();
            List<Paper> papers=authorRepository.findPapersByAuthorId(id);
            ans.put("Author",author);
            ans.put("Paper",papers);
        }
        return ans;
    }
}
