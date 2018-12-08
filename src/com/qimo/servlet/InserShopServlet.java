package com.qimo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimo.LoginDao.RegistDao;
import com.qimo.ShopDao.QueryShopDao;
import com.qimo.ShopDao.UpdateShopDao;
import com.qimo.entity.Shop;
import com.qimo.entity.Users;

@WebServlet("/InserShopServlet")
public class InserShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InserShopServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
     	String desc = request.getParameter("desc");
     	String pic = request.getParameter("img");
     	String color = request.getParameter("color");
     	String size = request.getParameter("size");
     	double price = Double.parseDouble( request.getParameter("price") );
     	int num =Integer.parseInt( request.getParameter("num") );
     	boolean result = false;
     	int id = QueryShopDao.queryLast();
		Shop shop = new Shop(id, "aaa", pic, desc, color, size, price, num);
		result = UpdateShopDao.insertDao(shop);
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
