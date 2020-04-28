package com.shishunan.hgshop.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml",
	"classpath:applicationContext-dubbo-provider.xml"})
public class TestBase {

}
