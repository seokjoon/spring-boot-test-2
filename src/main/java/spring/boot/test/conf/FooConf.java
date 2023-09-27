package spring.boot.test.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:foo.properties")
public class FooConf {

    @Autowired
    private Environment env;

    @Override
    public String toString() {
        return env.getProperty("foo");
    }
}
