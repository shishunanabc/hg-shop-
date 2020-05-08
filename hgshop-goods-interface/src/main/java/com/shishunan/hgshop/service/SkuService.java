package com.shishunan.hgshop.service;
/**
 * sku的管理
 * @author 师述男
 *
 */

import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.entity.Sku;
import com.shishunan.hgshop.entity.SkuVo;

public interface SkuService {
	/**
	 * 列表
	 * @param skuVo
	 * @return
	 */
	PageInfo<Sku> list(SkuVo skuVo);
	
	int add(Sku sku);
	
	int delete(int[] ids);
	
	int update(Sku sku);
	
	Sku getById(int id);
}
