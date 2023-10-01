package spring.boot.test.res.foo;
import lombok.Getter;
import spring.boot.test.entity.foo.Foo;

@Getter
public class FooRes {

    private final long id;
    private final int num;
    private final String title;

    public FooRes(Foo foo) {
        this.id = foo.id;
        this.num = foo.num;
        this.title = foo.title;
    }
}
