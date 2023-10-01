package spring.boot.test.controller.foo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import spring.boot.test.entity.foo.Foo;
import spring.boot.test.repo.foo.FooRepo;
import spring.boot.test.req.foo.FooReq;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureMockMvc
@SpringBootTest
class FooControllerTest {

    @Autowired
    FooRepo fooRepo;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext webApplicationContext;

//    @BeforeEach
//    public void beforeEachSetMockMvc() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        fooRepo.deleteAll();
//    }

    @DisplayName("create")
    @Test
    public void create() throws Exception {
        final String title = "title test";
        final FooReq fooReq = new FooReq(60, title);
        final String reqBody = objectMapper.writeValueAsString(fooReq);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/foo").contentType(MediaType.APPLICATION_JSON_VALUE).content(reqBody));
        resultActions.andExpect(MockMvcResultMatchers.status().isCreated());

        Iterable<Foo> foos = fooRepo.findAll();
        assertThat(StreamSupport.stream(foos.spliterator(), false).count()).isGreaterThanOrEqualTo(1);
        assertThat(foos.iterator().next().title).isEqualTo(title);
    }

    @DisplayName("read")
    @Test
    public void read() throws Exception {
        final String title = "title test";
        Foo foo = fooRepo.save(Foo.builder().num(70).title(title).build());
        final ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/foo/" + foo.id));
        resultActions
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(title));
    }

    @DisplayName("reads")
    @Test
    public void reads() throws Exception {
        final ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/foo").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }
}