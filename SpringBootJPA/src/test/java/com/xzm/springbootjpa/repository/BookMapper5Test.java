package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.ApplicationTest;
import com.xzm.springbootjpa.entity.Book;
import org.junit.Test;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class BookMapper5Test extends ApplicationTest {
    @Resource
    private BookMapper5 bookMapper;

    //单条件
    @Test
    public void test(){
        Specification<Book> specification = new Specification<Book>() {
            //类中内容
            //重写父类方法
            //第一个参数
            //第二个参数
            //第三个参数
            @Override
            public Predicate toPredicate(Root<Book> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                //封装条件
                Predicate pre =builder.equal(root.get("bookid"),5);

                return pre;
            }
        };
        List<Book> list=this.bookMapper.findAll(specification);
        for (Book book:list){
            System.out.println(book.getBookid()+":"+book.getBookname());
        }
    }

    //多条件
    @Test
    public void test_where(){
        Specification specification =new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder) {
               //数组:必须定义多少个
               // Predicate[] arr =new Predicate[2];
               // arr[0] =builder.equal(root.get("bookid"),1);
               //arr[1] =builder.equal(root.get("bookname"),"test2测试");
               // return builder.and(arr);


                //集合
                List<Predicate> list =new ArrayList<Predicate>();
                list.add(builder.equal(root.get("bookid"),1));
                list.add(builder.equal(root.get("bookname"),"test2测试"));

                return builder.and((Predicate[]) list.toArray());
            }
        };
        List<Book> list=this.bookMapper.findAll(specification);
        for (Book book:list){
            System.out.println(book.getBookid()+":"+book.getBookname());
        }
    }

    @Test
    public void test_where2(){
        Specification specification =new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder) {
                return builder.and(
                        builder.equal(root.get("bookid"),1),
                        builder.equal(root.get("bookname"),"test2测试"));
            }
        };
        List<Book> list=this.bookMapper.findAll(specification);
        for (Book book:list){
            System.out.println(book.getBookid()+":"+book.getBookname());
        }
    }

}
