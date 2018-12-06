package testingjava8;
import java.sql.*;

public class TestManageDBResource {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection(DBType.MYSQLDB);
			System.out.println("Connection to MySQL database established correctly");
		} catch (SQLException e) {
			
			System.err.println(e.getMessage());
		} finally {
			conn.close();
		}
		
	}
}
