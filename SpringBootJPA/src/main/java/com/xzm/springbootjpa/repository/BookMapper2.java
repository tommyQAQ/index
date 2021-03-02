package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//继承repository接口
//提供增删改
@Repository
public interface BookMapper2 extends CrudRepository<Book,Integer> {
}
