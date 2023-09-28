package spring.boot.test.db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.SQLException;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DbH2Test {

    @Autowired
    private DataSource dataSource;

    @Test
    public void exec() throws SQLException {
        assertThat(dataSource.getClass().getName()).isEqualTo("com.zaxxer.hikari.HikariDataSource");
        assertThat(dataSource.getConnection().getMetaData().getDatabaseProductName()).isEqualTo("H2");
    }
}
