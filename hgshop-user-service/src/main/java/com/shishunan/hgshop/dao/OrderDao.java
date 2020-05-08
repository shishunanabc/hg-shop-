package com.shishunan.hgshop.dao;

import java.util.List;

import com.shishunan.hgshop.entity.OrderDetail;
import com.shishunan.hgshop.entity.Orders;

public interface OrderDao {

	int add(Orders orders);

	int addDetail(OrderDetail orderDetail);
	
	List<Orders> ordersList(Integer uid);

}
