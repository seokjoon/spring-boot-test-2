package spring.boot.test.event.foo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FooEventListener {

    @EventListener
    public void foo(FooEvent event) throws InterruptedException {
        log.info("foo listener: " + event.getTitle());
    }
}
