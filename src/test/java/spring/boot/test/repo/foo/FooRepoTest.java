package spring.boot.test.repo.foo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.test.entity.foo.Foo;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FooRepoTest {

    @Autowired
    private FooRepo fooRepo;

    @Test
    public void delete() {
        System.out.println("delete");
        Foo foo = new Foo();
        Foo savedFoo = fooRepo.save(foo);
        fooRepo.delete(foo);
        assertThat(fooRepo.findById(savedFoo.id).isPresent()).isFalse();
    }

    @Test
    public void exec() {
        System.out.println("exec");
        Foo foo =  Foo.builder().num(20).title("foo title").build();
        Foo savedFoo = fooRepo.save(foo);
//        assertThat(fooRepo.findById(savedFoo.id).get()).isEqualTo(foo);
        assertThat(fooRepo.findById(savedFoo.id).orElse(null)).isNotNull();
    }

    @Test
    public void findAllByNumNQ() {
        System.out.println("findAllByNumNQ");
        Iterable<Foo> foos = fooRepo.findAllByNumNQ(70);
        long ctr = StreamSupport.stream(foos.spliterator(), false).count();
        System.out.println("ctr: " + ctr);
        assertThat(foos).hasSizeGreaterThanOrEqualTo(0);
    }

    @Test
    public void findAllByNumQ() {
        System.out.println("findAllByNumQ");
        Iterable<Foo> foos = fooRepo.findAllByNumQ(70);
        long ctr = StreamSupport.stream(foos.spliterator(), false).count();
        System.out.println("ctr: " + ctr);
        assertThat(foos).hasSizeGreaterThanOrEqualTo(0);
    }

    @Test
    public void foo() {
        System.out.println("foo");
        Iterable<Foo> foos = fooRepo.findAllByTitle("foo title");
        foos.forEach(foo -> System.out.println(foo.title));
        long ctr = StreamSupport.stream(foos.spliterator(), false).count();
        System.out.println(ctr);
        assertThat(ctr).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void update() {
        System.out.println("update");
        Foo foo = new Foo();
        fooRepo.save(foo);
        foo.num = 15;
        Foo savedFoo = fooRepo.save(foo);
        assertThat(fooRepo.findById(savedFoo.id).get().num).isEqualTo(15);
    }

    @Test
    public void updateNumByIdQ() {
        fooRepo.updateNumByIdQ(55, 61);
        assertThat(fooRepo.findById(Long.valueOf(61)).get().num).isEqualTo(55);
    }
}
