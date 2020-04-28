package com.shishunan.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.entity.Brand;

public interface BrandService {
	//添加
	int add(Brand brand);
	//查询
	PageInfo<Brand> list(String firstChar,int page);
	//批量删除
	int deleteBatch(int[] ids);
	//修改
	int update(Brand brand);
}
