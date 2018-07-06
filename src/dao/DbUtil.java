package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	//String driverName = "com.mysql.jdbc.Driver"; 
	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test"; 
	String userName = "sa"; 
	String userPwd = "13450376787zwq"; 

	public Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);
		return conn;
	}

	public void closeCon(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}

	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
