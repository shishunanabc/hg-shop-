package com.shishunan.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.dao.BrandDao;
import com.shishunan.hgshop.entity.Brand;
import com.shishunan.hgshop.service.BrandService;
@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandDao brandDao;
	//添加
	public int add(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.add(brand);
	}

	//查询
	public PageInfo<Brand> list(String firstChar, int page) {
		PageHelper.startPage(page, 5);
		return new PageInfo<Brand>(brandDao.list(firstChar));
	}

	public List<Brand> listAll(){
		return brandDao.listAll();
	}
	
	//批量删除
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		return brandDao.delete(ids);
	}

	//修改
	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.update(brand);
	}

	@Override
	public Brand getById(int id) {
		// TODO Auto-generated method stub
		return brandDao.getById(id);
	}

}
