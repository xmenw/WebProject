package com.qimo.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersUpdate {
	public static boolean Update(String sql, Object[] param) {
	Connection con = null;
	PreparedStatement psql = null;
	ResultSet rs = null;	
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	} catch (Exception e1) {
		System.out.println(e1);
	}
	try {
		String url = "jdbc:mysql://localhost:3306/yonghu?useSSL=true&characterEncoding=UTF-8";
		con = DriverManager.getConnection(url, "root", "");
		psql = con.prepareStatement(sql);
		psql.setObject(1, param[0]);
		psql.setObject(2, param[1]);
		int n  = psql.executeUpdate();
		if(n > 0){
			return true;
		}else{
			return false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
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
		return false;
	}
}
