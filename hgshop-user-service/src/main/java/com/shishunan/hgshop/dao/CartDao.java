package com.shishunan.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shishunan.hgshop.entity.Cart;

public interface CartDao {

	int add(@Param("uid")int uid, @Param("skuid")int skuId, @Param("pnum")int num);
	
	int delete(int ...ids);
	/**
	 * 根据用户id获取购物车
	 * @param uid
	 * @return
	 */
	List<Cart> list(int uid);

	List<Cart> listByIds(int[] ids);

	int deleteByIds(int[] ids);

}
