package com.vigorous.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.platform.bean.UserInfo;
import com.platform.dao.IUserDao;

public class UserDao extends JdbcDaoSupport implements IUserDao {
	
	//remember JdbcDaoSupport need to inject dataSource

	@Override
	public void userRegister(UserInfo ui) {
		JdbcTemplate template = getJdbcTemplate();
		String sql = "insert into tb_platform_users "
				+ " ( name, age, registerDate, is_active ) values "
				+ " ( ?, ?, ?, ? ) ";
		if (template == null) {
			System.out.println("==jdbc template is null");
		}
		int nextid = template.update(sql, new Object[] {ui.name,ui.age,ui.registerDate,ui.isActive});
		System.out.println("[db] register next id " + nextid);
	}

	@Override
	public List<UserInfo> listUsers() {
		return null;
	}

}
