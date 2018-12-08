package com.qimo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimo.LoginDao.RegistDao;
import com.qimo.ShopDao.UpdateShopDao;
import com.qimo.entity.Shop;
import com.qimo.entity.Users;

@WebServlet("/DelShopServlet")
public class DelShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelShopServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
     	String id = request.getParameter("id");
     	boolean result = false;
     	if(id == null){
			id = "";
		}
		result = UpdateShopDao.deleteDao(Integer.parseInt(id));		
		if(result){
			response.sendRedirect("ShopServlet?begin=1");
		}else {
			out.println("删除失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
