package com.xzm.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.xzm.bean.User;

//mysql数据库操作类，
//目的帮助实例实现功能而已，当作三层中的 DAO
public class MysqlHelper {

	//用户登录，返回User对象
	public static User userLogin(User u) {		
		try {			
			Class.forName("com.mysql.jdbc.Driver");			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web05?characterEncoding=utf-8","root","123456");
			Statement stmt = conn.createStatement();			
			ResultSet rs =  stmt.executeQuery("select * from `user` where `username`='"+u.getUsername()+"' and `password`='"+u.getPassword()+"';");
			if(rs.next()) {
				//完善数据
				u.setId(rs.getInt("id"));
				u.setCreatetime(rs.getDate("createtime"));
				//返回对象
				return u;
			}
			return null;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
}
