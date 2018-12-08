package com.qimo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.qimo.LoginDao.RegistDao;
import com.qimo.entity.Users;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
     	String username = request.getParameter("name");
		String password = request.getParameter("password");
		if(username == null || password == null){
			username = "";
			password = "";
		}
		RegistDao regist = new RegistDao();
		Users user = new Users(username, password);
		result = regist.setDao(user);
		if(result){
			response.sendRedirect("index.jsp");
		}else {
			out.println("注册失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
