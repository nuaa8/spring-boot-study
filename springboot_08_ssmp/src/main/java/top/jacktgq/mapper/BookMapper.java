package top.jacktgq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.jacktgq.pojo.Book;

/**
 * 下面使用MyBatisPlus
 */


@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
