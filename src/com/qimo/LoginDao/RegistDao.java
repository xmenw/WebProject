package com.qimo.LoginDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qimo.DBUtil.UsersUpdate;
import com.qimo.DBUtil.UsersQuery;
import com.qimo.entity.Users;

public class RegistDao {
	public boolean setDao(Users user) {
		String sql = "insert into users values(?,?)";
		Object[] param = {user.getName(), user.getPassword()};
		boolean result = false;
		result = UsersUpdate.Update(sql, param);
		return result;
	}
}
