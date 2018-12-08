<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.qimo.entity.Users" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="./css/bootstrap.css">
<style>
	.text-center {
		position: relative;
		top: 200px;
		padding: 30px 0px;
	}
	#img {
		position: absolute;
		top: -200px;
		left: 50%;
		transform: translateX(-45%);
	}
	
	:-webkit-full-screen {  
	  background-color: #fff !important;  
	} 
</style>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<img src="./image/x1.png" id="img"/>
			<form action="UserServlet" method="post" class="form-horizontal" style="display:inline-block;">
		        	<input type="text" autocomplete="off" placeholder="请输入用户名" name="username" class="form-control" id="user"><br>
		        	<input type="password" placeholder="请输入密码" name="password" class="form-control" id="pwd"><br>
		        	<input type="submit" name="login" value="登录" class="btn btn-success" style="margin-left:-60px;">
		    </form>
		    <form action="Regist.jsp" method="get" style="display:inline-block; margin-left:-80px;">
		        	<input type="submit" name="regist" value="注册" class="btn btn-primary">
		    </form>
	    </div>
    </div>
    <jsp:setProperty property="*" name="user"/>
    <script>
    	let lm = document.getElementsByClassName('container')[0];
    	window.onclick = ()=>{
    		lm.requestFullscreen();	
    	}
    	user.onfocus = ()=>{
    		img.src = "./image/x2.png";
    	}
    	user.onblur = ()=>{
    		img.src = "./image/x1.png";
    	}
    	pwd.onfocus = ()=>{
    		img.src = "./image/x3.png";
    	}
    	pwd.onblur = ()=>{
    		img.src = "./image/x1.png";
    	}
    	user.onchange = ()=> {
    		console.log(user.value);
    		sessionStorage.setItem("user",user.value);	
    	}
    </script>
</body>
</html>