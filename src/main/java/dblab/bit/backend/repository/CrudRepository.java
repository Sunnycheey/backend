package dblab.bit.backend.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * @program: backend
 * @description: Interface for common crud option
 * @author: lihuichao
 * @create: 2020-05-20
 **/
@Transactional
public interface CrudRepository<T, ID extends Serializable> extends Neo4jRepository<T, ID> {
    //<S extends T> S save(S entity);
    /*
    Optional<T> findById(ID primaryKey);

    Iterable<T> findAll();

    long count();

    void delete(T t);

    boolean existsById(ID primaryKey);
    */
}
