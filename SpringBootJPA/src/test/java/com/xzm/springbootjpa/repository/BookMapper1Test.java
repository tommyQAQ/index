package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.ApplicationTest;
import com.xzm.springbootjpa.entity.Book;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class BookMapper1Test extends ApplicationTest {
    @Resource
    private BookMapper1 bookMapper;

    @Test
    public void test_findByBookidAndBookname(){
        List<Book> list= this.bookMapper.findByBookidAndBookname(1,"西游记");
        for (Book book:list){
            System.out.println(book.getBookname());
        }
    }

    @Test
    public void test_findOrBookidAndBookname(){
        List<Book> list= this.bookMapper.findByBookidOrBookname(2,"天龙八部");
        for (Book book:list){
            System.out.println(book.getBookname());
        }
    }

    @Test
    public void test_queryByBookidSQL(){
        List<Book> list= this.bookMapper.queryByBookidSQL(6);
        for (Book book:list){
            System.out.println(book.getBookid()+book.getBookname());
        }
    }

}
