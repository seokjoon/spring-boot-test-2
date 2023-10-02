package spring.boot.test.res.foo;
import lombok.Getter;
import spring.boot.test.entity.foo.Foo;

import java.time.LocalDateTime;

@Getter
public class FooRes {

    private final LocalDateTime createdAt;
    private final long id;
    private final int num;
    private final String title;
    private final LocalDateTime updatedAt;

    public FooRes(Foo foo) {
        this.createdAt = foo.createdAt;
        this.id = foo.id;
        this.num = foo.num;
        this.title = foo.title;
        this.updatedAt = foo.updatedAt;
    }
}
