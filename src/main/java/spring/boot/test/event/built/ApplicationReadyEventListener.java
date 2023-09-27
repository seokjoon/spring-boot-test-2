package spring.boot.test.event.built;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import spring.boot.test.service.foo.FooService;

@Component
@Slf4j
public class ApplicationReadyEventListener {

    @Autowired
    FooService fooService;

    @EventListener
    public void listen(ApplicationReadyEvent event) {
        log.info("ready: " + event.getTimestamp());
        fooService.foo("foo");
    }
}