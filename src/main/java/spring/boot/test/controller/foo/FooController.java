package spring.boot.test.controller.foo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.test.data.FooData;
import spring.boot.test.entity.foo.Foo;
import spring.boot.test.service.foo.FooService;

@Slf4j
@RestController
public class FooController {

    @Autowired
    FooService fooService;

    @PostMapping("/foo")
    public Foo create(FooData fooData) {
        return fooService.create(fooData);
    }

    @GetMapping("/foo")
    public Iterable<Foo> reads() {
        Iterable<Foo> foos = fooService.reads();
        //log.info(foos.toString());
        return foos;
    }
}
