package spring.boot.test.event.foo;

public class FooEvent {

    private String title;

    public FooEvent(String title) {
        this.title = title;
        System.out.println("foo event");
    }

    public String getTitle() {
        return this.title;
    }
}
