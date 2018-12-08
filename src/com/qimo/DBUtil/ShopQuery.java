package com.qimo.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qimo.entity.Shop;
import com.sun.rowset.CachedRowSetImpl;

public class ShopQuery {
	public static List<Shop> Query(String sql, Object[] param) {
		List<Shop> lists = new ArrayList<Shop>();
		Connection con = null;
		PreparedStatement psql = null;
		CachedRowSetImpl rowSet;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e1) {
			System.out.println(e1);
		}
		try {
			String url = "jdbc:mysql://localhost:3306/shopcar?useSSL=true&characterEncoding=UTF-8";
			con = DriverManager.getConnection(url, "root", "");
			con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			psql = con.prepareStatement(sql);
			psql.setObject(1, "aaa");
			rs = psql.executeQuery();
			int i = 0;
			while(rs.next()){
				Shop shop = new Shop(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8));
				lists.add(shop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(psql != null)psql.close();
				if(rs != null)rs.close();
				if(con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
	}
	public static int QueryCount(String sql, Object[] param) {
		int lists = 0;
		Connection con = null;
		PreparedStatement psql = null;
		CachedRowSetImpl rowSet;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e1) {
			System.out.println(e1);
		}
		try {
			String url = "jdbc:mysql://localhost:3306/shopcar?useSSL=true";
			con = DriverManager.getConnection(url, "root", "");
			con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			psql = con.prepareStatement(sql);
			rs = psql.executeQuery();
			int i = 0;
			if(rs.next()){
				lists = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally{
			try {
				if(psql != null)psql.close();
				if(rs != null)rs.close();
				if(con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists % 5 == 0 ? (lists / 5) : (lists / 5) + 1;
	}

	public static int QueryLastIndex(String sql, Object[] param) {
		int index = 0;
		Connection con = null;
		PreparedStatement psql = null;
		CachedRowSetImpl rowSet;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e1) {
			System.out.println(e1);
		}
		try {
			String url = "jdbc:mysql://localhost:3306/shopcar?useSSL=true";
			con = DriverManager.getConnection(url, "root", "");
			con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			psql = con.prepareStatement(sql);
			rs = psql.executeQuery();
			int i = 0;
			if(rs.next()){
				index = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally{
			try {
				if(psql != null)psql.close();
				if(rs != null)rs.close();
				if(con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return index + 1;
	}
	
}

