<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.qimo.LoginDao.*" %>
<%@ page import="com.qimo.entity.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" href="./css/bootstrap.css">
</head>
<body>
	<div class="container" style="margin-top: 200px;">
		<div class="text-center">
			 <form action="RegistServlet" method="post" class="form-horizontal" style="display:inline-block;">
	        	<input type="text" name="name" autocomplete="off" placeholder="请输入用户名" class="form-control"><br>
	        	<input type="password" name="password" placeholder="请输入密码" class="form-control"><br>
	        	<input type="submit" name="regist" value="注册" class="btn btn-success">
		     </form>
 		</div>
    </div>
</body>
</html>