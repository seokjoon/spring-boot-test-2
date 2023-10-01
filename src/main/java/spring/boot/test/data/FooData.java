package spring.boot.test.data;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import spring.boot.test.entity.foo.Foo;

@NoArgsConstructor
@AllArgsConstructor
public class FooData {

    @Min(value = 2, message = "num minimum 2")
    private int num;

    private String title;

    public Foo toEntity() {
        return Foo.builder().num(this.num).title(this.title).build();
    }
}
