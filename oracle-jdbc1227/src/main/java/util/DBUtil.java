package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "gdj58";
		String dbPw = "dmstj1004";
		
		Class.forName(driver);
		conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
		conn.setAutoCommit(false);
		
		return conn;
	}
}
