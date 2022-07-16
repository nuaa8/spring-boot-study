package top.jacktgq.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jacktgq.pojo.Book;

/**
 * 数据层操作
 */
@SpringBootTest
public class BookMapperTestCase {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void testSelectById() {
        bookMapper.selectById(2);
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("神秘岛");
        book.setType("科幻");
        book.setDescription("《神秘岛》是法国科幻小说家儒勒·凡尔纳创作的长篇小说，是其三部曲的第三部，全书共3部62章。");

        bookMapper.insert(book);
    }

    @Test
    void testDelete() {
        bookMapper.deleteById(15);
    }

    @Test
    void testGetAll() {
        bookMapper.selectList(null);
    }

    //分页，需要拦截器，在MPConfig中 定义拦截器
    @Test
    void testGetPage() {
        IPage<Book> page = new Page(2, 5);   //第2页，显示5行
        bookMapper.selectPage(page, null);

        System.out.println("currentPage:" + page.getCurrent());  //2
        System.out.println("pageSize:" + page.getSize());//5
        System.out.println("total:" + page.getTotal());//13
        System.out.println("page:" + page.getPages());//13/5  向上取整3
        System.out.println("record:" + page.getRecords());//
    }

    //按条件查新
    @Test
    void testGetByCondition() {
        QueryWrapper<Book> qw = new QueryWrapper();
        qw.like("name", "spring");
        bookMapper.selectList(qw);
    }

    @Test
    void testGetByCondition2() {
        String name = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();   //语法检查
        /*if (name != null) {
            lqw.like(Book::getName, "Spring");
        }*/
        // 等价写法
        lqw.like(name != null, Book::getName, name);
        bookMapper.selectList(lqw);
    }
}
