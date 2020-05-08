package com.shishunan.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.dao.SkuDao;
import com.shishunan.hgshop.dao.SpuDao;
import com.shishunan.hgshop.entity.Sku;
import com.shishunan.hgshop.entity.Spu;
import com.shishunan.hgshop.entity.SpuVo;
import com.shishunan.hgshop.service.SpuService;
@Service(interfaceClass = SpuService.class)
public class SpuServiceImpl implements SpuService{

	@Autowired
	private SpuDao spuDao;
	@Autowired
	private SkuDao skuDao;
	@Override
	public PageInfo<Spu> list(SpuVo spuVo) {
		PageHelper.startPage(spuVo.getPage(), spuVo.getPageSize());
		return new PageInfo<Spu>(spuDao.list(spuVo));
	}

	@Override
	public int add(Spu spu) {
		// TODO Auto-generated method stub
		//添加商品主要逻辑
		//添加数据到MySQL数据库中
		//更新ES（可能用kafka 进行发送消息进行处理）
		//更新redis
		return spuDao.add(spu);
	}

	@Override
	public int update(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.update(spu);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		//删除商品的业务逻辑过程	
		//删除商品规格表（spuid->skuid => 删除商品规格sku_spec）
		//	删除sku（根据spuId 删除  hg_sku）
		//	删除spu表
		//	购物车。
		//	订单要不要删除？  不能删除
		return spuDao.delete(ids);
	}

	@Override
	public Spu getById(int id) {
		// TODO Auto-generated method stub
		return spuDao.getById(id);
	}
	//获取商品的详情
	@Override
	public Spu getSpuDetail(int spuId) {
		Spu spu=spuDao.getById(spuId);
		//获取sku
		List<Sku> skuList=skuDao.getBySpuId(spuId);
		spu.setSkuList(skuList);
		return spu;
	}

}
