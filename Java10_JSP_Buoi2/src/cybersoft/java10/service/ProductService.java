package cybersoft.java10.service;

import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.activation.Repository;

import cybersoft.java10.model.*;
import cybersoft.java10.repository.ProductRepository;

public class ProductService {
	/* properties */
	private List<Product> productList;
	private ProductRepository repository;

	/* constructors */
	public ProductService() {
		repository = new ProductRepository();
		productList = new ArrayList<Product>();
		
		productList.add(new Product(1, "Tivi LG 24inch", "LG24", "Tivi LG", 300));
		productList.add(new Product(2, "Tivi LG 25inch", "LG25", "Tivi LG", 500));
		productList.add(new Product(3, "Tivi LG 26inch", "LG26", "Tivi LG", 700));
		productList.add(new Product(4, "Tivi LG 27inch", "LG27", "Tivi LG", 1000));
		productList.add(new Product(5, "Tivi LG 28inch", "LG28", "Tivi LG", 550));
		productList.add(new Product(6, "Tivi LG 29inch", "LG29", "Tivi LG", 700));
		productList.add(new Product(7, "Tivi LG 30inch", "LG30", "Tivi LG", 800));
		productList.add(new Product(8, "Tivi LG 31inch", "LG31", "Tivi LG", 900));
		productList.add(new Product(9, "Tivi LG 32inch", "LG32", "Tivi LG", 1200));
	}

	/* methods */
	public void testConnection() {
		repository.testConnection();
	}
	
	public List<Product> getAllProducts(){
		return repository.getAllProduct();
	}
	
	public boolean add(Product product) {
		if(checkDuplicateId(product.getId()))
			return false;
		return productList.add(product);
	}
	
	public boolean remove(int id) {
		for (Product product : productList) {
			if(id == product.getId())
				return productList.remove(product);
		}
		
		return false;
	}
	
	public void update(int id, Product product) {
		for (int i = 0; i < productList.size(); i++) {
			if(productList.get(i).getId() != id) 
				continue;
			
			productList.set(i, product);
		}
	}
	
	private boolean checkDuplicateId(int id) {
		for (Product product : productList) {
			if(id == product.getId())
				return true;
		}
		return false;
	}

	public Product getProductById(int id) {
		for(Product product : productList) {
			if(product.getId() == id)
				return product;
		}
		return null;
	}
}
