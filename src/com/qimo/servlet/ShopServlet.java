package com.qimo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimo.ShopDao.QueryShopDao;
import com.qimo.entity.Shop;

@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		int begin = Integer.parseInt( request.getParameter("begin") );
		List<Shop> lists = QueryShopDao.setDao(begin);
		request.getSession().setAttribute("lists", lists);
		int count = QueryShopDao.queryCount();
		request.getSession().setAttribute("count", count);
		request.getRequestDispatcher("shopcar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
