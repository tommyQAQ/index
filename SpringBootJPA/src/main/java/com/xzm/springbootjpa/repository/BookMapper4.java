package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//前三个接口内容都能用
@Repository
public interface BookMapper4 extends JpaRepository<Book,Integer> {
}