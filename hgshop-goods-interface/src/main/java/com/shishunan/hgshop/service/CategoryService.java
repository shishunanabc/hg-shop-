package com.shishunan.hgshop.service;

import java.util.List;

import com.shishunan.hgshop.entity.Category;

public interface CategoryService {
	
	/**
	 * 根据父ID 列出所有的孩子
	 * @param parentId
	 * @return
	 */
	List<Category> list(int parentId);
	
	int add(Category cat);
	
	int update(Category cat);
	
	int delete(int id);
}
