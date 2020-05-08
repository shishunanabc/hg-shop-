package com.shishunan.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shishunan.hgshop.entity.Brand;

public interface BrandDao {

	int add(Brand brand);

	List<Brand> list(@Param("firstChar")String firstChar);

	int delete(int[] ids);

	int update(Brand brand);
	//查看数据
	Brand getById(@Param("id")int id);

	List<Brand> listAll();
	
}
