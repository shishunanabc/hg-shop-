package com.shishunan.hgshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.common.FileUtils;
import com.shishunan.hgshop.entity.Sku;
import com.shishunan.hgshop.entity.SkuVo;
import com.shishunan.hgshop.entity.Spec;
import com.shishunan.hgshop.entity.SpecOption;
import com.shishunan.hgshop.entity.Spu;
import com.shishunan.hgshop.service.SkuService;
import com.shishunan.hgshop.service.SpecService;
import com.shishunan.hgshop.service.SpuService;

@Controller
@RequestMapping("sku")
public class SkuController {

	@Reference
	private SkuService skuService;
	
	@Reference
	private SpuService spuService;
	
	@Reference
	private SpecService specService;
	
	/**
	 * 列表
	 */
	@RequestMapping("list")
	public String list(SkuVo skuVo,HttpServletRequest request) {
		PageInfo<Sku> pageInfo=skuService.list(skuVo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("skuVo", skuVo);
		return "sku/list";
	}
	/**
	 * 添加
	 */
	@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request,int spuId) {
		//获取要添加的spu
		Spu spu=spuService.getById(spuId);
		//获取所有的规格名称
		List<Spec> specList=specService.listAll();
		request.setAttribute("specList", specList);
		request.setAttribute("spu", spu);
		return "sku/add";
	}
	/**
	 * 添加
	 */
	@RequestMapping("add")
	@ResponseBody
	public boolean add(HttpServletRequest request,Sku sku,
			int[] specId,int[] optionId,MultipartFile imageFile,
			MultipartFile cartThumbnailFile) {
		
		List<SpecOption> specOption = new ArrayList<SpecOption>();
		
		for (int i = 0; i < optionId.length && i < optionId.length; i++) {
			SpecOption option=new SpecOption();
			option.setId(optionId[i]);
			option.setSpecId(specId[i]);
			specOption.add(option);
		}
		sku.setOptionList(specOption);
		try {
			String filePath = FileUtils.processFile(imageFile);
			String cartPath=FileUtils.processFile(cartThumbnailFile);
			sku.setCartThumbnail(cartPath);
			sku.setImage(filePath);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return skuService.add(sku)>0;
	}
	/**
	 * 修改回显
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(HttpServletRequest request,int id) {
		//获取要添加的spu
		Sku sku=skuService.getById(id);
		//获取所有的规格名称
		List<Spec> specList=specService.listAll();
		request.setAttribute("specList", specList);
		request.setAttribute("sku", sku);
		return "sku/update";
	}
	/**
	 * 修改
	 */
	@RequestMapping("update")
	@ResponseBody
	public boolean update(HttpServletRequest request,Sku sku,
			int[] specId,int[] optionId,MultipartFile imageFile,
			MultipartFile cartThumbnailFile) {
		
		List<SpecOption> specOption = new ArrayList<SpecOption>();
		
		for (int i = 0; i < optionId.length && i < optionId.length; i++) {
			SpecOption option=new SpecOption();
			option.setId(optionId[i]);
			option.setSpecId(specId[i]);
			specOption.add(option);
		}
		sku.setOptionList(specOption);
		try {
			String filePath = FileUtils.processFile(imageFile);
			String cartPath=FileUtils.processFile(cartThumbnailFile);
			sku.setCartThumbnail(cartPath);
			sku.setImage(filePath);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return skuService.update(sku)>0;
	}
	//删除
	@ResponseBody
	@RequestMapping("delBatch")
	public boolean delBatch(int[] ids) {
		System.err.println(ids);
		return skuService.delete(ids)>0;
	}
}
