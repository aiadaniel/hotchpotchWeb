package com.vigorous.dao.impl;

import java.sql.Timestamp;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.platform.bean.UserInfo;
import com.platform.dao.IUserDao;
import com.vigorous.base.BaseJUnitTest;

public class UserTest extends BaseJUnitTest {
	
	@Resource
	private IUserDao userDao;
	
	@Test
	@Transactional //标明该测试方法需要使用事务
	@Rollback(false) //不回滚，会污染数据哦，注意
	public void insertData() {
		for (int i = 0; i < 1000; i++) {
			UserInfo info = new UserInfo("name"+i, i%100+1, null, i%2==0);
			userDao.userRegister(info);
		}
		System.out.println("finish insert");
	}

}
