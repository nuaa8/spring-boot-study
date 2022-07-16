package top.jacktgq.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.jacktgq.pojo.Book;

/**
 * @Author CandyWall
 * @Date 2022/1/19--23:00
 * @Description
 */

//数据库SQL映射需要添加@Mapper 被容器识别到，让他产生自动代理的对象
@Mapper
public interface BookMapper {
    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);
}
