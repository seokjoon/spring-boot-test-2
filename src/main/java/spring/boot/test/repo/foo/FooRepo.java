package spring.boot.test.repo.foo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.boot.test.entity.foo.Foo;

@Repository
public interface FooRepo extends CrudRepository<Foo, Long> {

    boolean existsByTitle(String title);

    Iterable<Foo> findAllByTitle(String title);

    Iterable<Foo> findAllByTitleOrderByTitle(String title);

}
