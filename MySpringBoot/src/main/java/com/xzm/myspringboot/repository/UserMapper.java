package com.xzm.myspringboot.repository;

import com.xzm.myspringboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//数据持久层
@Repository
public interface UserMapper {
    /*
    *所有信息列表
    * @return 用户对象列表
     */
    List<User> selectUserList();

    User insertUser(@Param("user")User user);

   void deleteUserByuserId(@Param("userId")Integer userId);

   User selectUserByuserId(@Param("userId")Integer userId);

   void updateUserByuserId(@Param("user")User user);

   List<User> selectUserBygenderId(@Param("genderId") Integer genderId);
}
