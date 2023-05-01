package tobyspring.helloboot;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HellobootTest
public class TemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 내장형 디비를 사용한다면 테스트가 실행될때 DB 테이블이 없다면 테이블을 만들도록 하자
    @BeforeEach
    void setUp() {
         jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello values(?, ?)", "Hoseok", 3);
        jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 1);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        assertThat(count).isEqualTo(2L);
    }

}
