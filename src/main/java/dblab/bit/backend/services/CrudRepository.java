package dblab.bit.backend.services;

import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @program: backend
 * @description: Interface for common crud option
 * @author: lihuichao
 * @create: 2020-05-20
 **/
@Transactional
public interface CrudRepository<T, ID> extends Repository<T, ID> {
    //<S extends T> S save(S entity);
    Optional<T> findById(ID primaryKey);

    Iterable<T> findAll();

    long count();

    void delete(T t);

    boolean existsById(ID primaryKey);
}
