package com.shishunan.hgshop.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.entity.Brand;
import com.shishunan.hgshop.service.BrandService;
/**
 * 如果启动服务的情况下，不能启动单元测试，因为这时候会出现端口占用的冲突
 * @author 师述男
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml",
	"classpath:applicationContext-dubbo-provider.xml"})
public class TestBrand {
	//日志
	private static Logger log=Logger.getLogger(TestBrand.class);
	@Autowired
	private BrandService brandService;
	//添加测试
	@Test
	public void testAdd() {
		Brand brand=new Brand();
		brand.setFirstChar("L");
		brand.setName("张三丰");
		int result=brandService.add(brand);
		log.info("添加的结果是"+result);
	}
	//列表测试
	@Test
	public void testList() {
		PageInfo<Brand> pageInfo=brandService.list("", 1);
		List<Brand> list=pageInfo.getList();
		list.forEach(x->{
			log.info("x is"+x);
		});
	}
	//删除测试
	@Test
	public void testDelete() {
		int[] ids= {9,10};
		int deleteBatch=brandService.deleteBatch(ids);
		System.out.println(deleteBatch);
	}
	//修改测试
	@Test
	public void testUpdate() {
		Brand brand=new Brand();
		brand.setId(7);
		brand.setFirstChar("T");
		brand.setName("腾讯");
		int update=brandService.update(brand);
		System.out.println(update);
	}
}
