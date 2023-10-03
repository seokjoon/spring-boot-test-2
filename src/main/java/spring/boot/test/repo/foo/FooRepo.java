package spring.boot.test.repo.foo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.test.entity.foo.Foo;

@Repository
public interface FooRepo extends CrudRepository<Foo, Long> {

    boolean existsByTitle(String title);

    Iterable<Foo> findAllByTitle(String title);

    Iterable<Foo> findAllByTitleOrderByTitle(String title);

    Iterable<Foo> findAllByNumNQ(int num);

    @Query("select f from Foo f where f.num=?1")
    Iterable<Foo> findAllByNumQ(int num);

    @Modifying
    @Transactional
    @Query("update Foo f set f.num=:num where f.id=:id")
    int updateNumByIdQ(@Param("num") int num, @Param("id") long id);
}
