package com.myclass.repository.imp;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import com.myclass.db.DbConnection;
import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;

public class CategoryRepositoryImp implements CategoryRepository{
	DbConnection dbConnection;
	
	public CategoryRepositoryImp(DbConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public List<Category> getAll() {
		Connection conn = dbConnection.getConnection();
		
		if(conn == null)
			return null;
		
		List<Category> categories = new LinkedList<Category>();
		
		return categories;
	}

}
