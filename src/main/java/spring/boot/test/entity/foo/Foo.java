package spring.boot.test.entity.foo;

import jakarta.validation.constraints.Min;

public class Foo {

    @Min(value = 2, message = "foo minimum 2")
    public int foo;
}
