package spring.boot.test.repo.foo;

import org.springframework.stereotype.Repository;
import spring.boot.test.entity.foo.Foo;
import spring.boot.test.repo.SbRepo;

@Repository
public interface FooBarRepo extends SbRepo<Foo, Long> {

}
