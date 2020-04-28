package com.shishunan.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
