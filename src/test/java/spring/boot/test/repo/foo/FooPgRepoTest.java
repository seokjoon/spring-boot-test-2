package spring.boot.test.repo.foo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FooPgRepoTest {

    @Autowired
    private FooPgRepo fooPgRepo;

    @Test
    public void exec() {
        Pageable pageable = PageRequest.of(0, 2);
        assertThat(fooPgRepo.findAll(pageable)).hasSize(2);
        assertThat(pageable.getPageNumber()).isEqualTo(0);
        Pageable pageableNext = pageable.next();
        assertThat(fooPgRepo.findAll(pageableNext)).hasSize(2);
        assertThat(pageableNext.getPageNumber()).isEqualTo(1);
    }
}
