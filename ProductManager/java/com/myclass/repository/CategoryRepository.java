package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Category;

public interface CategoryRepository {
	public List<Category> getAll();
}
