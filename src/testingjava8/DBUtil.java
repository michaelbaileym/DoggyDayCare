package testingjava8;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//

public class DBUtil {
	private static final String cloudSqlUser = "kris";
	private static final String cloudSqlPwd = "welovedogs";
	private static final String cloudSQLCS = "jdbc:mysql://google/OakesDB?cloudSqlInstance=dogdaycare-224223:us-west1:daycaredb&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=" + cloudSqlUser + "&password=" + cloudSqlPwd + "&useSSL=false";
	private static final String mySqlUser = "root";
	private static final String mySqlPwd = "dwcgnzdt";
	private static final String mySqlCS = "jdbc:mysql://127.0.0.1:3306/OakesDB";

	public static Connection getConnection(DBType dbType) throws SQLException {
		switch (dbType) {
		case MYSQLDB:
			return DriverManager.getConnection(mySqlCS, mySqlUser, mySqlPwd);
		case CLOUDSQL:
			return DriverManager.getConnection("jdbc:mysql://google/Oakes?cloudSqlInstance=dogdaycare-224223:us-west1:daycaredb&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=kris&password=123456&useSSL=false");
		default:
			return null;
		}
	}
}

//