package com.shishunan.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.shishunan.hgshop.dao.CategoryDao;
import com.shishunan.hgshop.entity.Category;
import com.shishunan.hgshop.service.CategoryService;
@Service(interfaceClass = CategoryService.class)
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao catDao;
	
	@Override
	public List<Category> list(int parentId) {
		// TODO Auto-generated method stub
		return catDao.list(parentId);
	}

	@Override
	public int add(Category cat) {
		// TODO Auto-generated method stub
		return catDao.add(cat);
	}

	@Override
	public int update(Category cat) {
		// TODO Auto-generated method stub
		return catDao.update(cat);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return catDao.delete(id);
	}

}
