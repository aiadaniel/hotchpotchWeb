package com.platform.dao;

import java.util.List;

import com.platform.bean.UserInfo;

public interface IUserDao {
	
	public void userRegister(UserInfo ui);
	
	public List<UserInfo> listUsers();
}
