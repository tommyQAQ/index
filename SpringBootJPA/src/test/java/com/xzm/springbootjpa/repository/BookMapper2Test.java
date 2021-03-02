package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.ApplicationTest;
import com.xzm.springbootjpa.entity.Book;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class BookMapper2Test extends ApplicationTest {
    @Resource
    private BookMapper2 bookMapper;

    @Test
    public void test(){
      /*
       Long count = this.bookMapper.count();
       this.bookMapper.findAll();
       this.bookMapper.existsById(Integer id);
       this.bookMapper.findAllById(List<Integer> list);
       this.bookMapper.findById(Integer id);
       */
    }

    //有主键 执行update,where id
    //没有主键 执行insert
    @Test
    public void test_save(){
        Book book = new Book();

        book.setAuthor(555);
        book.setBookname("test2测试");
        book.setPrice(5.00);
        book.setNum(100);

        this.bookMapper.save(book);
        System.out.println("添加成功");
    }

    @Test
    public void test_save_update(){
        Book book = new Book();
        book.setBookid(1);
        book.setAuthor(555);
        book.setBookname("test2测试");
        book.setPrice(5.00);
        book.setNum(100);

        this.bookMapper.save(book);
        System.out.println("更新成功");

    }
}
