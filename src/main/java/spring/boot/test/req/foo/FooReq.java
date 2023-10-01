package spring.boot.test.req.foo;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.boot.test.entity.foo.Foo;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Slf4j
public class FooReq {

    @Min(value = 2, message = "num minimum 2")
    private int num;

    private String title;

    public Foo toEntity() {
        return Foo.builder().num(this.num).title(this.title).build();
    }

//    public String toString() {
//        return "num: " + this.num + ", title: " + this.title;
//    }
}
