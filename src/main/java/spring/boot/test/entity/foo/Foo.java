package spring.boot.test.entity.foo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "foo")
public class Foo {

    @Id
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

//    @Column(name = "num")
    @Min(value = 2, message = "num minimum 2")
    public int num = 30;

//    @Column(name = "title")
    public String title = "default title";

//    public Foo(int num, String title) {
//        this.num = num;
//        this.title = title;
//    }
}
