package com.shishunan.hgshop.service;

import java.util.List;

import com.shishunan.hgshop.entity.Cart;
import com.shishunan.hgshop.entity.HgUser;
import com.shishunan.hgshop.entity.Orders;
/**
 * 用户的服务接口
 * @author 师述男
 *
 */
public interface UserService {
	//注册
	HgUser register(HgUser user);
	//登录
	HgUser login(HgUser user);
	//判断是否存在同名的用户
	boolean isExist(String username);
	
	int addCart(Integer uid, int skuId, int num);
	//列出购物车
	List<Cart> listCart(Integer uid);
	//生成订单
	int createOrder(Integer uid,int[] ids,String address);
	//查询订单
	List<Orders> ordersList(Integer uid);

}
