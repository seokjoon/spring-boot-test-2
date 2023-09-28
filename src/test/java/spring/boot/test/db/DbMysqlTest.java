package spring.boot.test.db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DbMysqlTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void exec() throws SQLException {
        ResultSet rs = null;
        int noOfFoo = 0;
        try(PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("SELECT COUNT(1) FROM foo")) {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                noOfFoo = rs.getInt(1);
            }
            assertThat(noOfFoo).isEqualTo(2L);
        }
        finally {
            if(rs != null) rs.close();
        }
    }
}
