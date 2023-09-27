package spring.boot.test.event.foo;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FooEventListener {

    @EventListener
    public void foo(FooEvent event) throws InterruptedException {
        System.out.println("foo listener: " + event.getTitle());
    }
}
