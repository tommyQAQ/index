package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//对表中所有数据分类排序
//无法添加条件
@Repository
public interface BookMapper3 extends PagingAndSortingRepository<Book,Integer> {
}
