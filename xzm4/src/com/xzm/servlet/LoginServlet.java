package com.xzm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzm.bean.User;
import com.xzm.dbutility.MysqlHelper;
import com.xzm.util.Encryption;

//用户登录的业务处理Servlet
//地址栏Mapping，对应<form action="login"
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	//【get请求】：
	//	当前是登录页面的处理，不允许用户直接打开的
	//	get方法就处理直接打开时的操作
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//如果用户没有登录--->显示登录页面login.jsp		
		//如果用户登录了  --->直接引导显示主页index.jsp
		//Session就是判断依据，判断是否有指定名称的session		
		if( request.getSession().getAttribute("user")!=null )
		{
			//登录了，跳转到主页
			response.sendRedirect("index.jsp");
		}
		else
		{
			//没有登录
			response.sendRedirect("login.jsp");
		}
		
		
		
	
	}

	
	
	//【post请求】
	//	用户有表单提交，进行登录操作
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//不用提供预览，不设置头部信息
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		
		
		//获取对应的信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//密码加密
		password = Encryption.toMD5(Encryption.toMD5(password)+password);
		
		//创建对象
		User u = new User();
		
		//属性赋值
		u.setUsername(username);
		u.setPassword(password);
		
		//调用方法得到返回对象
		u = MysqlHelper.userLogin(u);
		
		//判断是否登录成功
		if(u != null) {
			//成功了:【将用户信息保存到session中】
			//从请求对象中，获取session，进行参数设置
			//可以创建多个，名字是标识，字符串
			//值是object
			request.getSession().setAttribute("user", u);
			System.out.println("session设置成功");
			
			//页面跳转到主页去
			response.sendRedirect("index.jsp");
			
		}
		else {
			//失败了：显示提示语句
			//显示js，通过js跳转页面
			String msg = "<script>alert('用户名 或 密码 错误！');window.location.href='login.jsp';</script>";
			response.getWriter().print(msg);
		}
		
		
		//上面路径跳转只是一个方法调用，不是return
		//这里的代码依然会执行
		//判断是否要记住用户名
		//能不能获取到 checkbox，打勾的提交，没有打勾的，不会提交
		if(request.getParameter("save")!=null) 
		{
			//【写cookie】
			
			//第一步：创建一个Cookie对象(名字,值)
			//cookie只能保存字符串String
			Cookie ck = new Cookie("username",u.getUsername());
			
			//第二步：设置这个Cookie的时效
			//秒，
			ck.setMaxAge(3600);
			
			//第三步：设置这个cookie的操作作用域
			//默认那里创建cookie，就只能那里用
			//如果需要其他sevlet或jsp可以使用
			//这里设置表示：当前网站所有位置都可以使用
			ck.setPath("/");
			
			//第四步：输出追加写入到客户端浏览器中
			response.addCookie(ck);
			
			//测试
			System.out.println("cookie 创建成功！");
			
		}
		else 
		{
			//【删除】
			//第一步：获取浏览器请求发送的所有cookie，返回数组
			Cookie[] arr = request.getCookies();
			
			//第二步：循环遍历
			for(int i=0; i<arr.length; i++)
			{
				//判断找出需要删除的
				if( arr[i].getName().equals("username") )
				{
					//服务器无法删除客户端浏览器的cookie
					//只能设置时效过期，让浏览器自动删除
					//把value值清除
					arr[i].setValue(null);
					//设置时效
					arr[i].setMaxAge(0);
					//作用域
					arr[i].setPath("/");
					//放回去,自动替换原有的
					response.addCookie(arr[i]);
				}
			}
			
		}
		
	}

}
