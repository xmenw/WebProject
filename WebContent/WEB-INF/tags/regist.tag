<%@ tag import="java.util.Calendar"%>
<%@ tag pageEncoding="UTF-8" %>
<%@ tag import="java.sql.*"%>
<%@ attribute name="username" required="true" %>
<%@ attribute name="password" required="true" %>
<%@ variable name-given="result" scope="AT_END" %>
	<%
		String msg = "";
		Connection con;
		PreparedStatement pre;
		ResultSet rs;
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
			String insertCond = "insert into users values(?,?)";
			pre = con.prepareStatement(insertCond);
			pre.setString(1, username);
			pre.setString(2, password);
			int m = pre.executeUpdate();
			if(m != 0){
				msg = "注册成功";
			}
			con.close();
		} catch (SQLException e) {
				msg = "注册失败";
		}
		jspContext.setAttribute("result", new String(msg));
	%>