package com.shishunan.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shishunan.hgshop.entity.Spec;
import com.shishunan.hgshop.entity.SpecOption;

public interface SpecDao {

	int add(Spec spec);

	int addSpecOption(SpecOption x);

	int update(Spec spec);

	int deleteSpecOption(int ...id);

	int delete(int[] ids);

	List<Spec> list();

	Spec getById(@Param("id")int id);


}
