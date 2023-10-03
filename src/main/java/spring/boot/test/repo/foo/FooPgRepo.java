package spring.boot.test.repo.foo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import spring.boot.test.entity.foo.Foo;

@Repository
public interface FooPgRepo extends PagingAndSortingRepository<Foo, Long> {

}
