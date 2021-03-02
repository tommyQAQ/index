package com.xzm.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet声明周期
 */
@WebServlet("/life")
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //第一步：构造方法
    public LifeServlet() {    	
        super();
    }

	//第二步：初始化方法
	public void init(ServletConfig config) throws ServletException {
		//父类方法中有代码，我们可以追加定义新的代码
		//前提必须先执行父类代码
		super.init(config);
	}

	
	//第三步：服务拦截
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}
	
	
	//第四步：对应的处理方法
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
		
	//第五步：析构-销毁
	public void destroy() {
		super.destroy();
	}

	

	

}
