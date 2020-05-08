package com.shishunan.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.entity.Brand;
import com.shishunan.hgshop.service.BrandService;

@Controller
@RequestMapping("brand")
public class BrandController {
	//品牌
	@Reference
	private BrandService brandService;
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue = "1")int page,
			@RequestParam(defaultValue = "")String firstChar) {
		PageInfo<Brand> pageInfo=brandService.list(firstChar, page);
		request.setAttribute("pageInfo", pageInfo);
		return "brand/list";
	}
	@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request) {
		return "brand/add";
	}
	@RequestMapping("add")
	@ResponseBody
	public boolean add(HttpServletRequest request,Brand brand) {
		return brandService.add(brand)>0;
	}
	
	@RequestMapping("toUpdate")
	public String toUpdate(HttpServletRequest request,int id) {
		Brand brand = brandService.getById(id);
		//数据回显
		request.setAttribute("brand", brand);
		return "brand/update";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public boolean update(HttpServletRequest request,Brand brand) {
		return brandService.update(brand)>0;
	}
	/**
	 * 批量删除
	 * @param request
	 * @param ids
	 * @return
	 */
	@RequestMapping("delBatch")
	@ResponseBody
	public Boolean delBatch(HttpServletRequest request,@RequestParam("ids[]") int[] ids) {
		return brandService.deleteBatch(ids)>0;		
	}
}
