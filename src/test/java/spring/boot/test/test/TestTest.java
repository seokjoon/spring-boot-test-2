package spring.boot.test.test;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTest {

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @Test
    public void test() {
        System.out.println("test");
    }
}
