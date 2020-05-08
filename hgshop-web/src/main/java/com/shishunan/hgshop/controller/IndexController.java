package com.shishunan.hgshop.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.common.HgConstant;
import com.shishunan.hgshop.entity.Category;
import com.shishunan.hgshop.entity.HgUser;
import com.shishunan.hgshop.entity.Spu;
import com.shishunan.hgshop.entity.SpuVo;
import com.shishunan.hgshop.service.CategoryService;
import com.shishunan.hgshop.service.SpuService;
import com.shishunan.hgshop.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private RedisTemplate<String, PageInfo<Spu>> rdTemplate;
	@Reference
	private SpuService spuService;
	@Reference
	private UserService userService;
	@Reference
	private CategoryService catService;
	
	
	@RequestMapping({"/","index"})
	public String index(HttpServletRequest request,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "0") int catId) {
		SpuVo vo=new SpuVo();
		vo.setPageSize(12);
		vo.setPage(page);
		vo.setCategoryId(catId);
		PageInfo<Spu> pageInfo=null;
		//如果是首页考虑缓存
		if(catId==0 && page==1) {
			ValueOperations<String, PageInfo<Spu>> opsForValue = rdTemplate.opsForValue();
			//缓存中有  则使用缓存中的
			if(rdTemplate.hasKey(HgConstant.CACHE_SPU_KEY)) {
				 pageInfo = opsForValue.get(HgConstant.CACHE_SPU_KEY);
			}else {
				//缓存中没有 从数据库中获取 并放入缓存
				pageInfo = spuService.list(vo);
				opsForValue.set(HgConstant.CACHE_SPU_KEY, pageInfo, 10, TimeUnit.MINUTES);
			}
		}else {
			// 其他页码的数据 或者是有分类的信息 跳过缓存
			pageInfo = spuService.list(vo);
		}
		
		request.setAttribute("pageInfo", pageInfo);
		//查询条件的回显
		request.setAttribute("catId", catId);
		return "index";
	}
	//获取分类树数据
	@RequestMapping("treeData")
	@ResponseBody
	public List<Category> treeData(){
		List<Category> list=catService.list(0);
		return list;
	}
	
	//获取分类树数据
	@RequestMapping("spuDetail")
	public String spuDetail(HttpServletRequest request,int spuId){
		Spu spu=spuService.getSpuDetail(spuId);
		System.err.println(spu);
		request.setAttribute("spu", spu);
		return "detail";
	}
	//加入购物车
	@RequestMapping("addCart")
	@ResponseBody
	public String addCart(HttpServletRequest request,int skuId,int num) {
		HgUser user = (HgUser) request.getSession().getAttribute(HgConstant.SESSION_KEY);
		if (user==null) {
			return "您尚未登录";
		}
		int result=userService.addCart(user.getUid(),skuId,num);
		return result > 0 ? "加入成功":"加入失败" ;
	}
}
