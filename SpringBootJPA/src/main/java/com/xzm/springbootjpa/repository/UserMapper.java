package com.xzm.springbootjpa.repository;


import com.xzm.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//数据持久层接口
@Repository
public interface UserMapper extends JpaRepository <User,Integer >{

}
