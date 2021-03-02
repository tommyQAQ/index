package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


@org.springframework.stereotype.Repository
public interface BookMapper1 extends Repository<Book,Integer> {
    //Book findBybookidAndbookname(Integer bookid,String bookname);

    List<Book> findByBookidAndBookname(Integer bookid,String bookname);

    List<Book> findByBookidOrBookname(Integer bookid,String bookname);


    //自定义sql语句
    //一般用queryBy定义，实际可以用任意名字定义
    //默认关闭，nativeQuery = true打开
    @Query(value = "select * from `book` where `bookid`=:id",nativeQuery = true)
    List<Book> queryByBookidSQL(@Param("id")Integer id);

}
