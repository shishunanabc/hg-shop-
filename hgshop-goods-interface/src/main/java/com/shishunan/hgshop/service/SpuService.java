package com.shishunan.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.entity.Spu;
import com.shishunan.hgshop.entity.SpuVo;

public interface SpuService {

	//查询
	PageInfo<Spu> list(SpuVo spuVo);
	
	int add(Spu spu);
	
	int update(Spu spu);
	
	int delete(int[] ids);
	//修改之前的回显
	Spu getById(int id);
	/*
	 * 获取spu详情
	 */
	Spu getSpuDetail(int spuId);
}
