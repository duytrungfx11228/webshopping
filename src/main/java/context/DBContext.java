
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

	
	public  Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/shoppingdb";
		final String user = "root";
		final String password = "trung123";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(url, user, password);
				return conn;
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} 
		
		return null;
	}

	
}
