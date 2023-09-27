package spring.boot.test.service.foo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import spring.boot.test.event.foo.FooEvent;

@RequiredArgsConstructor
@Service
@Slf4j
public class FooService {

    final ApplicationEventPublisher publisher;

//    public FooService(ApplicationEventPublisher applicationEventPublisher) {
//        this.publisher = applicationEventPublisher;
//        log.info("foo pub");
//    }

    public void foo(String title) {
        log.info("pub: " + title);
        publisher.publishEvent(new FooEvent(title));
    }
}
