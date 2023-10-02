package spring.boot.test.service.foo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.test.req.foo.FooReq;
import spring.boot.test.entity.foo.Foo;
import spring.boot.test.event.foo.FooEvent;
import spring.boot.test.repo.foo.FooRepo;

@RequiredArgsConstructor
@Service
@Slf4j
public class FooService {

    final ApplicationEventPublisher publisher;

    @Autowired
    FooRepo fooRepo;

//    public FooService(ApplicationEventPublisher applicationEventPublisher) {
//        this.publisher = applicationEventPublisher;
//        log.info("foo pub");
//    }

    public Foo create(FooReq fooReq) {
        return fooRepo.save(fooReq.toEntity());
    }

    public void delete(long id) {
        fooRepo.deleteById(id);
    }

    //test
    public void foo(String title) {
        log.info("pub: " + title);
        publisher.publishEvent(new FooEvent(title));
    }

    public Foo read(long id) {
        return fooRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public Iterable<Foo> reads() {
        return fooRepo.findAll();
    }

    @Transactional
    public Foo update(long id, FooReq fooReq) {
        //JPA는 별도의 수정 메소드 없이 객체를 조회해서 값을 변경하면 트랜잭션 커밋시 반영
        Foo foo = fooRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        foo.update(fooReq);
        return foo;
    }
}
