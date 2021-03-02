package com.xzm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handle")
public class HandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//【get请求】
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数的值显示
		response.getWriter().print("doGet: " + request.getParameter("username"));
		
	}

	//【post请求】
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数的值显示
		response.getWriter().print("doPost: " + request.getParameter("username"));
				
		
	}

}
