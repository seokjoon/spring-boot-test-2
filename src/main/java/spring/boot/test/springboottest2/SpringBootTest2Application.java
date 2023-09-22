package spring.boot.test.springboottest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@SpringBootApplication
public class SpringBootTest2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTest2Application.class, args);
    }

    @RequestMapping("/")
    String index() {
        return "index.html";
    }
}
