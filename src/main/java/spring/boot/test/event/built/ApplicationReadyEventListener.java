package spring.boot.test.event.built;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import spring.boot.test.service.foo.FooService;

@Component
public class ApplicationReadyEventListener {

    @Autowired
    FooService fooService;

    @EventListener
    public void listen(ApplicationReadyEvent event) {
        System.out.println("ready: " + event.getTimestamp());

        fooService.foo("foo");

    }
}