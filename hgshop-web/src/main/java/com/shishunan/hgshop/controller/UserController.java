package com.shishunan.hgshop.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shishunan.hgshop.common.HgConstant;
import com.shishunan.hgshop.entity.Cart;
import com.shishunan.hgshop.entity.HgUser;
import com.shishunan.hgshop.entity.Orders;
import com.shishunan.hgshop.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Reference
	private UserService userService;

	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(HgConstant.SESSION_KEY);
		return "redirect:/index";
	}
	
	@GetMapping("login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("login")
	public String login(HttpServletRequest request,HgUser user) {
		HgUser loginUser=userService.login(user);
		if (loginUser==null) {
			//清楚session
			request.getSession().removeAttribute(HgConstant.SESSION_KEY);
			request.setAttribute("error", "用户名密码错误");
			return "user/login";
		}
		//保存session
		request.getSession().setAttribute(HgConstant.SESSION_KEY, loginUser);
		//进入到个人中心
		return "user/home";
	}
	
	@GetMapping("register")
	public String register() {
		return "user/register";
	}
	
	@PostMapping("register")
	public String register(HttpServletRequest request,HgUser user) {
		//验证校验码是否正确
		String existCode = (String) request.getSession().getAttribute(HgConstant.SESSION_CODE);
		if (existCode==null || !existCode.equals(user.getCode())) {
			request.setAttribute("error", "验证码错误");
			return "user/register";
		}
		boolean exist=userService.isExist(user.getUsername());
		//存在
		if (exist) {
			request.setAttribute("error", "已经存在同名用户");
			return "user/register";
		}
		HgUser hgUser=userService.register(user);
		if (hgUser==null) {
			request.setAttribute("error", "用户注册失败，请稍后再试");
			return "user/register";
		}
		//跳转到登录页面
		return "redirect:login";
	}
	//获取验证码
	@PostMapping("getValiCode")
	@ResponseBody
	public boolean getValiCode(HttpServletRequest request) {
		//随机生成字符串 四位数字的
		Random random=new Random();
		int r = 1000+random.nextInt(9000);
		System.err.println("随机验证码是" + r);
		request.getSession().setAttribute(HgConstant.SESSION_CODE, r+"");
		return true;
	}
	
	//购物车列表
	@RequestMapping("cartlist")
	public String cartList(HttpServletRequest request) {
		HgUser loginUser = (HgUser) request.getSession().getAttribute(HgConstant.SESSION_KEY);
		List<Cart> listCart=userService.listCart(loginUser.getUid());
		
		request.setAttribute("cartList", listCart);
		return "user/cartlist";
	}
	
	//生成订单
	@RequestMapping("createOrder")
	@ResponseBody
	public boolean createOrder(HttpServletRequest request,String address,@RequestParam("ids[]")int[] ids) {
		//获取当前登录的用户
		HgUser loginUser = (HgUser) request.getSession().getAttribute(HgConstant.SESSION_KEY);
		userService.createOrder(loginUser.getUid(),ids,address);
		
		return true;
	}
	
	@RequestMapping("ordersList")
	public String ordersList(HttpServletRequest request) {
		 HgUser user = (HgUser)request.getSession().getAttribute(HgConstant.SESSION_KEY);
		 Integer uid = user.getUid();
		 List<Orders> list=userService.ordersList(uid);
		 request.setAttribute("user", user);
		 request.setAttribute("list", list);
		return "user/orderList";
	}
}
