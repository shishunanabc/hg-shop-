package com.shishunan.hgshop.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.shishunan.hgshop.dao.CartDao;
import com.shishunan.hgshop.dao.OrderDao;
import com.shishunan.hgshop.dao.UserDao;
import com.shishunan.hgshop.entity.Cart;
import com.shishunan.hgshop.entity.HgUser;
import com.shishunan.hgshop.entity.OrderDetail;
import com.shishunan.hgshop.entity.Orders;
import com.shishunan.hgshop.service.UserService;
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private OrderDao orderDao;
	
	public HgUser register(HgUser user) {
		// 对密码加密  根据明文计算密文 //加严
		String pwdMd5=DigestUtils.md5Hex(user.getPassword() + user.getUsername() + "aa");
		user.setPassword(pwdMd5);
		//添加到数据库
		userDao.add(user);
		//从数据库反查并返回
		return userDao.getUserById(user.getUid());
	}

	public HgUser login(HgUser user) {
		// 计算加严加密的密文
		String pwdMd5=DigestUtils.md5Hex(user.getPassword() + user.getUsername() + "aa");
		
		return userDao.findByPwd(user.getUsername(),pwdMd5);
	}

	public boolean isExist(String username) {
		// TODO Auto-generated method stub
		return userDao.findByName(username) != null;
	}

	public int addCart(Integer uid, int skuId, int num) {
		// TODO Auto-generated method stub
		return cartDao.add(uid,skuId,num);
	}

	public List<Cart> listCart(Integer uid) {
		// TODO Auto-generated method stub
		return cartDao.list(uid);
	}

	public int createOrder(Integer uid, int[] ids,String address) {
		List<Cart> cartList  = cartDao.listByIds(ids);
		
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		//总价格 整个订单的总价格
		BigDecimal totoal=new BigDecimal(0);
		//根据购物车的数据生成订单明细的数据
		for (Cart cart : cartList) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setPnum(cart.getPnum());
			orderDetail.setSkuid(cart.getSkuid());
			//计算一条数据的总价格                     乘
			orderDetail.setTotal(cart.getUnitPrice().multiply(BigDecimal.valueOf(cart.getPnum())));
			
			//价格进行累加
			totoal=totoal.add(orderDetail.getTotal());
			details.add(orderDetail);
		}
		Orders orders=new Orders();
		orders.setAddress(address);
		//整个订单的价格计算
		orders.setSumtotal(totoal);
		//用户id
		orders.setUid(uid);
		
		//生成主表 添加到主表
		orderDao.add(orders);
		
		//添加子表
		for (OrderDetail orderDetail : details) {
			//获取逻辑外键
			orderDetail.setOid(orders.getOid());
			orderDao.addDetail(orderDetail);
		}
		//删除购物车中的数据
		cartDao.deleteByIds(ids);
		return 0;
	}

	public List<Orders> ordersList(Integer uid) {
		// TODO Auto-generated method stub
		return orderDao.ordersList(uid);
	}
}
