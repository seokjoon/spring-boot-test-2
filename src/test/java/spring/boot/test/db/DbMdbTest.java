package spring.boot.test.db;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class DbMdbTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void foo() {

        DBObject object = BasicDBObjectBuilder.start().add("foo", "bar").get();
        mongoTemplate.save(object, "collection");
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("foo").containsOnly("bar");
    }
}
