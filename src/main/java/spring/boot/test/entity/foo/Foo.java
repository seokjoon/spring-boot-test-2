package spring.boot.test.entity.foo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import spring.boot.test.req.foo.FooReq;

import java.time.LocalDateTime;

@Entity
@NamedQueries({
    @NamedQuery(name = "Foo.findAllByNumNQ", query = "select f from Foo f where f.num=?1"),
})
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "foo")
public class Foo {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @CreatedDate
    public LocalDateTime createdAt;

//    @Column(name = "num")
    @Min(value = 2, message = "num minimum 2")
    public int num = 30;

    @Column(length = 128, nullable = false)
    public String title = "default title";

    @LastModifiedDate
    public LocalDateTime updatedAt;


    @Builder
    public Foo(int num, String title) {
        this.num = num;
        this.title = title;
    }

//    @PostLoad
//    @PrePersist
//    @PreUpdate
//    @PreRemove
//    @PostPersist
//    @PostUpdate
//    @PostRemove

    public void update(FooReq fooReq) {
        this.num = fooReq.getNum();
        this.title = fooReq.getTitle();
    }
}
