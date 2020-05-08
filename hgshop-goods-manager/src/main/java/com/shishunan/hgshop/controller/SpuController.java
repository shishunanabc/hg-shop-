package com.shishunan.hgshop.controller;

import java.io.IOException;
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
import com.shishunan.hgshop.entity.Brand;
import com.shishunan.hgshop.entity.Spu;
import com.shishunan.hgshop.entity.SpuVo;
import com.shishunan.hgshop.service.BrandService;
import com.shishunan.hgshop.service.SpuService;
/**
 * spu管理
 * @author 师述男
 *
 */
@Controller
@RequestMapping("spu")
public class SpuController {

	@Reference
	private SpuService spuService;
	@Reference
	private BrandService brandService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,SpuVo spuVo) {
		PageInfo<Spu> pageInfo=spuService.list(spuVo);
		List<Brand> brandList=brandService.listAll();
		//查询品牌商品
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("spuVo", spuVo);
		//回显品牌商品
		request.setAttribute("brandList", brandList);
		return "spu/list";
	}
	/**
	 * 
	 * @param request
	 * @param spu
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public boolean add(HttpServletRequest request , 
			Spu spu,@RequestParam("imgFile") MultipartFile imgFile) {
		try {
			String filePath = FileUtils.processFile(imgFile);
			spu.setSmallPic(filePath);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return spuService.add(spu)>0;
		
	}
	@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request) {
		
		//获取品牌
		List<Brand> brandList = brandService.listAll();
		request.setAttribute("brandList", brandList);
		
		return "spu/add";
	}
	@ResponseBody
	@RequestMapping("delBatch")
	public boolean delBatch(int[] ids) {
		return spuService.delete(ids)>0;
	}
}
