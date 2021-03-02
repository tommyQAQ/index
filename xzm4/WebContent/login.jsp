<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户登录</title>
</head>
<body>

	<h1>用户登录</h1>

	<!-- 
		action定义了提交路径，对应一个servlet
		jsp是 java+html混合的
	 -->
	<form name="f1" action="login" method="post">
	
		用户名：
		<!-- 嵌入代码：
				注意：引号与<之间，不能有任何内容
		 -->
		<input name="username" type="text" value="<%
			
			//获取请求的所有cookie
			Cookie[] arr = request.getCookies();
			
			//自定义变量，checkbox要不要选中
			boolean flag = false;
		
			//循环遍历
			for(int i=0; i<arr.length; i++){
				if(arr[i].getName().equals("username")){
					//使用内置out对象输出结果，会自动匹配位置
					out.print( arr[i].getValue() );
					flag=true;
				}
			}
		
		%>" />
		<br /><br />
	
		密码：
		<input name="password" type="password" />
		<br /><br />
	
		<label>
			<input name="save" type="checkbox" value="1" <%
				
				if(flag){
					out.print("checked");
				}
			
			%> />
			记住用户名
		</label>
		<br /><br />
	
		<input name="sub" type="submit" value="提交表单" />
	
	</form>
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>