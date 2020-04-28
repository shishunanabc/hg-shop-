package com.shishunan.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.elasticsearch.rest.RestRequest.Method;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shishunan.hgshop.entity.Admin;
import com.shishunan.hgshop.service.AdminService;
@Controller
public class IndexController {

	@Reference
	private AdminService adminService;
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	/**
	 * 接收页面的登录请求
	 * @return
	 */
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public String login(HttpServletRequest request, Admin admin) {
		Admin login=adminService.login(admin);
		System.err.println(login);
		if (login==null) {
			return "login";
		}
		request.getSession().setAttribute("sessionkey", admin);
		//进入管理页面
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
