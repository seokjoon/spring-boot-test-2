package spring.boot.test.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class FooRun {

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            log.info("commandLineRunner foo");
        };
    }
}
