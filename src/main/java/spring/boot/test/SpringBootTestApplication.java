package spring.boot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootTestApplication {

    @RequestMapping("/foo")
    String foo() {
        return "foo";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);
    }
}
