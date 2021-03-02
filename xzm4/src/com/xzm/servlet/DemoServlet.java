package com.xzm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//不使用默认的注解方式，就需要到配置文件中定义
// web.xml中
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//【get请求】
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Servlet OK！");
		
		
		
	}

	
	
	
}
