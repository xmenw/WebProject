<%@ tag pageEncoding="UTF-8" %>
<%@ tag import="java.sql.*"%>
<%@ attribute name="username" required="true" %>
<%@ attribute name="password" required="false" %>
<%@ variable name-given="queryResult" scope="AT_END" %>
	<%
		Connection con;
		Statement sql;
		ResultSet rs;
		StringBuffer result = new StringBuffer();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			String url = "jdbc:mysql://localhost:3306/yonghu?useSSL=true";
			con = DriverManager.getConnection(url, "root", "");
			DatabaseMetaData metaData = con.getMetaData();
			ResultSet set = metaData.getColumns(null, null, "users", null);
			sql = con.createStatement();
			rs = sql.executeQuery("select * from users where username = '" + username + "' and password = '" + password + "'" );
			if(rs.next()){
				result.append("登陆成功");
			}
			con.close();
		} catch (SQLException e) {
			result.append("请输入正确的用户名密码");
		}
		jspContext.setAttribute("queryResult", new String(result));
	%>