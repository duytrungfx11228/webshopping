
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

	
	public  Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/shoppingdb";
		final String user = "root";
		final String password = "trung123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				return DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
