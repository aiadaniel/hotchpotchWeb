package com.platform.service.impl;

import java.util.List;

import com.platform.dao.IDao;
import com.platform.service.IService;

public abstract class BaseService<T> implements IService<T> {
	
	IDao dao;

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao userDao) {
		this.dao = userDao;
	}

	@Override
	public T find(Class<T> clazz, String nickname) {
		return (T) dao.find(clazz, nickname);
	}

	@Override
	public abstract int create(T basebean);

	@Override
	public void save(T basebean) {
		dao.save(basebean);
	}

	@Override
	public void delete(T basebean) {
		dao.delete(basebean);
	}

	@Override
	public List<T> list(String sql) {
		return dao.list(sql);
	}

	@Override
	public int getTotalCount(String sql, Object... params) {
		return dao.getTotalCount(sql, params);
	}

	@Override
	public List<T> list(String sql, int first, int max, Object... params) {
		return dao.list(sql, first, max, params);
	}
	
	

}
