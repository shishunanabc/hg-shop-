package com.shishunan.hgshop.dao;

import java.util.List;

import com.shishunan.hgshop.entity.Category;

public interface CategoryDao {

	List<Category> list(int parentId);

	int add(Category cat);

	int update(Category cat);

	int delete(int id);

}
