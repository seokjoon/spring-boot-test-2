package spring.boot.test.entity.foo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
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

    @Column(nullable = false)
    public String title = "default title";

    @LastModifiedDate
    public LocalDateTime updatedAt;


    @Builder
    public Foo(int num, String title) {
        this.num = num;
        this.title = title;
    }

    public void update(int num, String title) {
        this.num = num;
        this.title = title;
    }
}
