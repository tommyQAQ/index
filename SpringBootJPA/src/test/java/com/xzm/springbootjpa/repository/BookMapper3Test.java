package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.ApplicationTest;
import org.junit.Test;
import org.springframework.data.domain.Sort;


import javax.annotation.Resource;


public class BookMapper3Test extends ApplicationTest {
    @Resource
    private BookMapper3 bookMapper;

    @Test
    public void test(){
        //this.bookMapper.findAll(Sort sort);
        //this.bookMapper.findAll(Pageable pageable);
    }

    @Test
    public void test_sort(){
        Sort.Order order =new Sort.Order(Sort.Direction.DESC,"bookid");


    }



}
