package spring.boot.test.run;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import spring.boot.test.entity.foo.Foo;

import java.util.Set;

@Component
@Order(1)
@Slf4j
public class FooRun {

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            log.info("================== commandLineRunner foo");
            fooValid();
        };
    }

    private void fooValid() {
        Foo foo = new Foo();
        //foo.foo = 1;
        foo.foo = 2;
        log.info("fooValid.foo: " + foo.foo);
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Foo>> violations = validator.validate(foo);
        violations.forEach(fooValidConstraintViolation -> log.error("fooValidConstraintViolation: [{}]", fooValidConstraintViolation));
    }
}
