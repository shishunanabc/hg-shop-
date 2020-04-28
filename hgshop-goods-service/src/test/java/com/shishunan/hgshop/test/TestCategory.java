package com.shishunan.hgshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shishunan.hgshop.entity.Category;
import com.shishunan.hgshop.service.CategoryService;
/**
 * 分类测试
 * @author 师述男
 *
 */
public class TestCategory extends TestBase{

	@Autowired
	private CategoryService catService;
	@Test
	public void testList() {
		List<Category> list=catService.list(0);
		System.out.println("list is"+list);
	}
}
