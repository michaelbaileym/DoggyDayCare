package testingjava8;
import java.sql.*;

public class TestOracleConnection {
	static final String dbURl ="jdbc:mysql://127.0.0.1:3306/OakesDB";
	static final String username = "root"; 
	static final String password = "dwcgnzdt"; 

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(dbURl, username, password);
			
			System.out.println("Connection to MySQL database established correctly");
		} catch (SQLException e) {
			
			System.err.println(e.getMessage());
		} finally {
			conn.close();
		}
		
	}
}
