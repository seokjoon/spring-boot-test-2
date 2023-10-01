package spring.boot.test.controller.foo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.test.req.foo.FooReq;
import spring.boot.test.entity.foo.Foo;
import spring.boot.test.res.foo.FooRes;
import spring.boot.test.service.foo.FooService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class FooController {

    @Autowired
    FooService fooService;

    @PostMapping("/foo")
    public ResponseEntity<Foo> create(@RequestBody FooReq fooData) {
        Foo foo = fooService.create(fooData);
        return ResponseEntity.status(HttpStatus.CREATED).body(foo);
    }

    @GetMapping("/foo/{id}")
    public ResponseEntity<FooRes> read(@PathVariable long id) {
        Foo foo = fooService.read(id);
        return ResponseEntity.ok().body(new FooRes(foo));
    }

    @GetMapping("/foo")
    //public ResponseEntity<Iterable<Foo>> reads() {
    public ResponseEntity<List<FooRes>> reads() { //FIXME
        Iterable<Foo> foos = fooService.reads();
        List<FooRes> fs = new ArrayList<FooRes>();
        foos.forEach(foo -> { fs.add(new FooRes(foo)); });
        return ResponseEntity.ok().body(fs);
    }
}
