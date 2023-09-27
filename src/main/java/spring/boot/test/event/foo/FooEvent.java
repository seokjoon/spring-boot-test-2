package spring.boot.test.event.foo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FooEvent {

    private String title;

    public FooEvent(String title) {
        this.title = title;
        log.info("foo event");
    }

    public String getTitle() {
        return this.title;
    }
}
