package DataAccessObjectPattern;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 	SINGLETON DATABASE CONNECTION
 */

public class DatabaseConnection {

	// Initializing Connection variable
	public static Connection conn;

	// Initializing static block
	static {

		// SQL connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/world?autoReconnect=true&useSSL=false",
					"cctstudent", "Pass1234!");
			// catch
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.out.println("not success");
		}

	}

	public static Connection MySQLConnection() {

		return conn; // returning connection

	}
}