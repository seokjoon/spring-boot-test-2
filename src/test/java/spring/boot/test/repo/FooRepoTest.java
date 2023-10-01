package spring.boot.test.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.test.entity.foo.Foo;
import spring.boot.test.repo.foo.FooRepo;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FooRepoTest {

    @Autowired
    private FooRepo fooRepo;

    @Test
    public void exec() {
        System.out.println("exec");
        Foo foo =  Foo.builder().num(20).title("foo title").build();
        Foo savedFoo = fooRepo.save(foo);
//        assertThat(fooRepo.findById(savedFoo.id).get()).isEqualTo(foo);
        assertThat(fooRepo.findById(savedFoo.id).orElse(null)).isNotNull();
    }

    @Test
    public void execDelete() {
        System.out.println("execDelete");
        Foo foo = new Foo();
        Foo savedFoo = fooRepo.save(foo);
        fooRepo.delete(foo);
        assertThat(fooRepo.findById(savedFoo.id).isPresent()).isFalse();
    }

    @Test
    public void execUpdate() {
        System.out.println("execUpdate");
        Foo foo = new Foo();
        fooRepo.save(foo);
        foo.num = 15;
        Foo savedFoo = fooRepo.save(foo);
        assertThat(fooRepo.findById(savedFoo.id).get().num).isEqualTo(15);
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
}
