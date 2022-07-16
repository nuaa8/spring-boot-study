package top.jacktgq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jacktgq.mapper.BookMapper;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    //1.先注入想要用的变量
    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        System.out.println(bookMapper.getById(10));
    }

}
