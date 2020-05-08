package com.shishunan.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.dao.SkuDao;
import com.shishunan.hgshop.entity.Sku;
import com.shishunan.hgshop.entity.SkuVo;
import com.shishunan.hgshop.entity.SpecOption;
import com.shishunan.hgshop.service.SkuService;
@Service(interfaceClass = SkuService.class)
public class SkuServiceImpl implements SkuService{

	@Autowired
	private SkuDao skuDao;
	@Override
	public PageInfo<Sku> list(SkuVo skuVo) {
		PageHelper.startPage(skuVo.getPage(), skuVo.getPageSize());
		return new PageInfo<Sku>(skuDao.list(skuVo));
	}

	@Override
	public int add(Sku sku) {
		int result=skuDao.add(sku);
		//插入子表
		List<SpecOption> optionList=sku.getOptionList();
		for (SpecOption specOption : optionList) {
			result += skuDao.addSkuOption(sku.getId(),specOption);
		}
		return result;
	}

	@Override
	public int delete(int[] ids) {
		int result=skuDao.deleteSkuOptionBySkuId(ids);//根据skuId 删除子表
		result += skuDao.deleteById(ids);
		return result;
	}

	@Override
	public int update(Sku sku) {
		//1.根据skuId  删除子表
		int result=skuDao.deleteSkuOptionBySkuId(sku.getId());//根据skuId 删除子表
		//2.修改主表内容
		result += skuDao.update(sku);
		//重新插入子表
		List<SpecOption> optionList=sku.getOptionList();
		for (SpecOption specOption : optionList) {
			result += skuDao.addSkuOption(sku.getId(),specOption);
		}
		return result;
	}

	@Override
	public Sku getById(int id) {
		// TODO Auto-generated method stub
		return skuDao.getById(id);
	}

}
