package com.qimo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimo.LoginDao.LoginDao;
import com.qimo.entity.Users;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		Boolean result = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username == null || password == null){
			username = "";
			password = "";
		}
		LoginDao login = new LoginDao();
		Users user = new Users(username, password);
		result = login.setDao(user);
		if(result) {
			response.sendRedirect("index.html");
		}else{
			out.println("登录失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
