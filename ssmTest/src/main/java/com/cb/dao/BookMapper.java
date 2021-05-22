package com.cb.dao;

import com.cb.pojo.Books;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BookMapper {
    //查询全部书
    List<Books> queryAllBook();

    //增加书籍
    int insert(Books books);

    //删除书籍
    int delete(@PathVariable("bookID") int id);

    //修改书籍
    int update (Books books);

    //根据id找书
    Books queryById(@PathVariable("bookID") int id);

    //模糊查询
    List<Books> queryMoHu(String bookName);

}
