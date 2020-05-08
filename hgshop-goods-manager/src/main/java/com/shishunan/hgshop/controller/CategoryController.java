package com.shishunan.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shishunan.hgshop.entity.Category;
import com.shishunan.hgshop.service.CategoryService;

@Controller
@RequestMapping("cat")
public class CategoryController {

	@Reference
	private CategoryService catService;
	//获取分类树数据
	@RequestMapping("treeData")
	@ResponseBody
	public List<Category> treeData(){
		List<Category> list=catService.list(0);
		return list;
	}
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("list")
	public String list() {
		return "category/list";
	}
	/**
	 * 添加
	 * @param request
	 * @param cat
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public boolean add(HttpServletRequest request,Category cat) {
		return catService.add(cat)>0;
	}
	/**
	 * 修改
	 * @param request
	 * @param cat
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public boolean update(HttpServletRequest request,Category cat) {
		return catService.update(cat)>0;
	}
	/**
	 * 删除
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("del")
	@ResponseBody
	public boolean del(HttpServletRequest request,int id) {
		return catService.delete(id)>0;
	}
}
