package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.ApplicationTest;
import com.xzm.springbootjpa.entity.Book;
import org.junit.Test;
import javax.annotation.Resource;


public class BookMapper4Test extends ApplicationTest {
    @Resource
    private BookMapper4 bookMapper;

    @Test
    public void test(){
        Book book =this.bookMapper.getOne(1);
        System.out.println(book.getBookid()+":"+book.getBookname());
    }

}
