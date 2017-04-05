package com.vigorous.service.impl;

import java.util.List;

import com.platform.service.IService;
import com.platform.service.impl.BaseService;
import com.vigorous.bean.Category;

public class CategoryService<T extends Category> extends BaseService<T> implements IService<T> {

	@Override
	public T find(Class<T> clazz, String nickname) {
		return null;
	}

	@Override
	public int create(T basebean) {
		if (dao.createQuery("").setParameter("", 1).list().size() > 0) {
			throw new RuntimeException("类别 " + basebean.getName() + " 已经存在。");
		}
		return dao.create(basebean);
	}

	@Override
	public void save(T basebean) {
	}

	@Override
	public void delete(T basebean) {
	}

	@Override
	public List<T> list(String sql) {
		return null;
	}

	@Override
	public int getTotalCount(String sql, Object... params) {
		return 0;
	}

	@Override
	public List<T> list(String sql, int first, int max, Object... params) {
		return null;
	}

}
