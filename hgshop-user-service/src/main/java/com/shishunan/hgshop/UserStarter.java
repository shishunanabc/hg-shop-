package com.shishunan.hgshop;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserStarter {
	//日志
	private static Logger log=Logger.getLogger(UserStarter.class);
	public static void main(String[] args) throws IOException {
		log.info("开始启动商品服务");
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml",
						"classpath:applicationContext-dubbo-provider.xml");
		context.start();
		log.info("恭喜您！启动商品服务成功");
		//阻塞
		System.in.read();
	}
}
