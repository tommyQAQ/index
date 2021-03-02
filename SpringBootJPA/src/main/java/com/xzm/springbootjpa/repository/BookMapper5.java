package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//独立接口
//支持多条件查询，并且可以在查询中添加分页、排序
//不能单独使用，需配合前四个接口使用
//多重接口继承
@Repository
public interface BookMapper5 extends
        JpaSpecificationExecutor<Book>,
        JpaRepository<Book,Integer> {
}