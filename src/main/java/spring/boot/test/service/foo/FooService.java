package spring.boot.test.service.foo;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import spring.boot.test.event.foo.FooEvent;

@Service
@RequiredArgsConstructor
public class FooService {

    final ApplicationEventPublisher publisher;

//    public FooService(ApplicationEventPublisher applicationEventPublisher) {
//        this.publisher = applicationEventPublisher;
//        System.out.println("foo pub");
//    }

    public void foo(String title) {
        System.out.println("pub: " + title);
        publisher.publishEvent(new FooEvent(title));
    }
}
