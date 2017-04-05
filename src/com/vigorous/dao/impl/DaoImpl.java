package com.vigorous.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.platform.bean.BaseBean;
import com.platform.dao.IDao;
import com.platform.utils.ErrCodeBase;

public class DaoImpl<T extends BaseBean> extends HibernateDaoSupport implements IDao<T> {

	//lxm:使用sessionFactory方式需要自己管理关闭，同时事务得不得支持，也需要自己操作
	@Override
	public T find(Class<T> clazz, int id) {
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public T find(Class<T> clazz, String nickname) {
		return null;
	}

	@Override
	public int create(T basebean) {
		 getHibernateTemplate().persist(basebean);
		 return ErrCodeBase.ERR_SUC;
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

	@Override
	public Query createQuery(String query) {
		return null;
	}

}
