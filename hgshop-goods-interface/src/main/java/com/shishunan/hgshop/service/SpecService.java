package com.shishunan.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.entity.Spec;

public interface SpecService {
	//添加一个规格
	int add(Spec spec);
	
	//修改
	int update(Spec spec);
	
	//删除
	int delete(int[] ids);
	
	//列表
	PageInfo<Spec> list(int page,int pageSize);

	Spec getById(int id);
}
