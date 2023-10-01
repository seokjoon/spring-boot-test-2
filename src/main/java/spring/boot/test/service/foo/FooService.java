package spring.boot.test.service.foo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import spring.boot.test.data.FooData;
import spring.boot.test.entity.foo.Foo;
import spring.boot.test.event.foo.FooEvent;
import spring.boot.test.repo.foo.FooRepo;

@RequiredArgsConstructor
@Service
@Slf4j
public class FooService {

    final ApplicationEventPublisher publisher;

    @Autowired
    FooRepo fooRepo;

//    public FooService(ApplicationEventPublisher applicationEventPublisher) {
//        this.publisher = applicationEventPublisher;
//        log.info("foo pub");
//    }

    public Foo create(FooData fooData) {
        return fooRepo.save(fooData.toEntity());
    }

    public void foo(String title) {
        log.info("pub: " + title);
        publisher.publishEvent(new FooEvent(title));
    }

    public Iterable<Foo> reads() {
        return fooRepo.findAll();
    }
}
