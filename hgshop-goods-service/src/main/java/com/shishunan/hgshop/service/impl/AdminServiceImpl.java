package com.shishunan.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.shishunan.hgshop.entity.Admin;
import com.shishunan.hgshop.service.AdminService;
/**
 * 实现service接口的
 * @author 师述男
 *
 */
@Service
@PropertySource("classpath:hgshop.properties")
@Configuration
public class AdminServiceImpl implements AdminService{
	private static Logger log=Logger.getLogger(AdminServiceImpl.class);
	@Value("${admin.username}")
	private String adminName;
	
	@Value("${admin.pwd}")
	private String adminPwd;
	
	@Override
	public Admin login(Admin admin) {
		log.info("login param is"+admin);
		if (adminName!=null && adminName.equals(admin.getName())
				&& adminPwd!=null && adminPwd.equals(admin.getPassword())
				) {
			log.info("login result is"+admin);
			return admin;
		}
		log.info("login result is null");
		//登录失败
		return null;
	}

}
