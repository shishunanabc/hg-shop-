package com.shishunan.hgshop.dao;

import org.apache.ibatis.annotations.Param;

import com.shishunan.hgshop.entity.HgUser;

public interface UserDao {

	int add(HgUser user);

	HgUser getUserById(Integer uid);

	HgUser findByPwd(@Param("uname")String username, @Param("pwd")String pwdMd5);

	HgUser findByName(String username);

}
