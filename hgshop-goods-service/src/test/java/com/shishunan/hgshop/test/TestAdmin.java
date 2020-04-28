package com.shishunan.hgshop.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shishunan.hgshop.entity.Admin;
import com.shishunan.hgshop.service.AdminService;

/**
 * 测试管理员登录功能
 * @author 师述男
 *
 */
public class TestAdmin extends TestBase{
	//日志
	private static Logger log=Logger.getLogger(TestAdmin.class);
	
	@Autowired
	private AdminService adminService;
	@Test
	public void testLoginTrue() {
		Admin admin=new Admin();
		admin.setName("ssn");
		admin.setPassword("123456");
		Admin login=adminService.login(admin);
		log.info("测试登录成功："+login);
	}
	@Test
	public void testLoginFalse() {
		Admin admin=new Admin();
		admin.setName("ssn");
		admin.setPassword("123456");
		Admin login=adminService.login(admin);
		log.info("测试登录失败："+login);
	}
}
