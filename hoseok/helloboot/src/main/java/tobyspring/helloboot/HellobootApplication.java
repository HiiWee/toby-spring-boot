package tobyspring.helloboot;

import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication  // 왜 스프링 부트 애플리케이션을 만들면 다음 애노테이션을 붙이는지 알 수 있다.
public class HellobootApplication {

    private final JdbcTemplate jdbcTemplate;

    public HellobootApplication(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }


    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

}