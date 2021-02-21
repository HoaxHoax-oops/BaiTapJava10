package cybersoft.java10.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java10.jdbc.MySqlConnection;
import cybersoft.java10.model.Product;

public class ProductRepository {
	
	public void testConnection() {
		Connection connection = MySqlConnection.getConnection();
		if(connection != null)
			System.out.println("Kết nối thành công!");
		else
			System.out.println("Kết nối thất bại!");
	}
	
	public List<Product> getAllProduct(){
		Connection connection = MySqlConnection.getConnection();
		if(connection == null)
			return null;
		List<Product> productList = new LinkedList<Product>();
		String query = "SELECT * FROM products";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			
			while(results.next()) {
				Product product = new Product();
				product.setId(results.getInt("id"));
				product.setName(results.getNString("name"));
				product.setCode(results.getNString("code"));
				product.setDescription(results.getNString("description"));
				product.setPrice(results.getFloat("price"));
				
				productList.add(product);
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}
}
