package spring.boot.test.repo;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface SbRepo<T, ID> extends Repository<T, ID> {

    <S extends T> S save(S entity);

    Iterable<T> findAll();
}
