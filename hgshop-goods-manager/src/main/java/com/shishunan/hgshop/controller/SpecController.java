package com.shishunan.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.entity.Spec;
import com.shishunan.hgshop.entity.SpecOption;
import com.shishunan.hgshop.service.SpecService;
/**
 * 规格的管理
 * @author 师述男
 *
 */
@Controller
@RequestMapping("spec")
public class SpecController {
	static int PAGE_SIZE=5;
	@Reference
	private SpecService specService;
	/**
	 * 列表
	 * @param request
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue = "1")int page) {
		
		PageInfo<Spec> pageInfo=specService.list(page, PAGE_SIZE);
		
		request.setAttribute("pageInfo", pageInfo);
		return "spec/list";
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
		return specService.delete(ids)>0;		
	}
	
	/**
	 * 添加功能
	 * @return  
	 */
	@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request) {
		return "spec/add";
	}
	/**
	 * 
	 * @return  
	 */
	@RequestMapping("add")
	@ResponseBody
	public boolean add(HttpServletRequest request,Spec spec) {
		List<SpecOption> optionList = spec.getSpecOption();
		//清理没有用空数据
		for (int i = optionList.size()-1; i >=0; i--) {
			if(optionList.get(i).getOptionName()==null)
				optionList.remove(i);
		}
		return specService.add(spec)>0;
	}
	/**
	 *  进入修改页面
	 * @return  
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(HttpServletRequest request,int id) {
		Spec spec = specService.getById(id);
		//数据回显
		request.setAttribute("spec", spec);
		return "spec/update";
	}
	
	/**
	 * 
	 * @return  
	 */
	@RequestMapping("update")
	@ResponseBody
	public boolean update(HttpServletRequest request,Spec spec) {
		List<SpecOption> optionList = spec.getSpecOption();
		//清理没有用空数据
		for (int i = optionList.size()-1; i >=0; i--) {
			if(optionList.get(i).getOptionName()==null)
				optionList.remove(i);
		}
		
		return specService.update(spec)>0;
	}
	/**
	 * 根据规格Id 获取规格所有的属性名称和值的列表
	 * @param specId
	 * @return
	 */
	@RequestMapping("getOptions")
	@ResponseBody
	public List<SpecOption> getOptions(int specId){
		Spec spec = specService.getById(specId);
		return spec==null?null:spec.getSpecOption();
	}
}
