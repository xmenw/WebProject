package com.qimo.LoginDao;

import com.qimo.DBUtil.UsersQuery;
import com.qimo.entity.Users;
public class LoginDao {
	public Boolean setDao(Users user) {
		String sql = "select * from users where username = ? and password = ?";
		Object[] param = {user.getName(), user.getPassword()};
		boolean result = false;
		result = UsersQuery.Query(sql, param);
		return result;
	}
}
