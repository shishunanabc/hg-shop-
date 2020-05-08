package com.shishunan.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shishunan.hgshop.dao.SpecDao;
import com.shishunan.hgshop.entity.Spec;
import com.shishunan.hgshop.service.SpecService;
@Service
public class SpecServiceImpl implements SpecService{
	
	@Autowired
	private SpecDao specDao;
	/**
	 * return  返回影响数据的条数
	 */
	@Override
	public int add(Spec spec) {
		// 添加主表
		final int result = specDao.add(spec);//必须生成主键
		//添加子表
		spec.getSpecOption().forEach(x->{
			x.setSpecId(spec.getId());//设置外键
			specDao.addSpecOption(x);//插入子表
		});
		return result;
	}

	@Override
	public int update(Spec spec) {
		//修改主表
		int result = specDao.update(spec);
		//根据外键删除原有的子表的数据
		specDao.deleteSpecOption(spec.getId());
		//重新添加子表
		spec.getSpecOption().forEach(x->{
			x.setSpecId(spec.getId());//设置外键
			specDao.addSpecOption(x);//插入子表
		});
		return result;
	}

	@Override
	public int delete(int[] ids) {
		//根据外键删除原有的子表的数据
		int result = specDao.deleteSpecOption(ids);
		//删除主表的数据
		result = specDao.delete(ids);
		return result;
	}

	@Override
	public PageInfo<Spec> list(int page, int pageSize) {
		//分页
		PageHelper.startPage(page, pageSize);
		return new PageInfo<Spec>(specDao.list());
	}

	@Override
	public Spec getById(int id) {
		// TODO Auto-generated method stub
		return specDao.getById(id);
	}

	@Override
	public List<Spec> listAll() {
		// TODO Auto-generated method stub
		return specDao.listAll();
	}

}
