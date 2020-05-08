package com.shishunan.hgshop.dao;

import java.util.List;

import com.shishunan.hgshop.entity.Spu;
import com.shishunan.hgshop.entity.SpuVo;

public interface SpuDao {

	List<Spu> list(SpuVo spuVo);

	int add(Spu spu);

	int update(Spu spu);

	int delete(int[] ids);

	Spu getById(int id);

}
