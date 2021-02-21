package cybersoft.java10.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	// database information
	private	static String url		= "jdbc:mysql://localhost:3306/jdbc";
	private static String username	= "root";
	private static String password	= "1234";
	
	// getConnection method
	public static Connection getConnection() {
		try {
			// khối lệnh
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Không đọc được Driver JDBC!");
		} catch (SQLException exc) {
			System.out.println("Lỗi kết nối database. Vui lòng kiểm tra username, password");
		}
		return null;
	}
}
