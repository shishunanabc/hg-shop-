package com.shishunan.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shishunan.hgshop.entity.Sku;
import com.shishunan.hgshop.entity.SkuVo;
import com.shishunan.hgshop.entity.SpecOption;

public interface SkuDao {

	List<Sku> list(SkuVo skuVo);

	int add(Sku sku);

	int addSkuOption(@Param("skuId")Integer id, @Param("op")SpecOption specOption);

	int deleteBySpuId(int[] ids);
	
	int deleteSkuOptionBySkuId(int ...ids);
	
	int deleteById(int[] ids);

	int update(Sku sku);

	Sku getById(int id);
	//根据spuid 获取所有的sku
	List<Sku> getBySpuId(int spuId);

}
