package com.platform.dao;

import java.util.List;

public interface IDao<T> {
	
	public T find(Class<T> clazz,int id);
	public T find(Class<T> clazz,String nickname);
	
	public void create(T basebean);
	
	public void save(T basebean);
	
	public void delete(T basebean);
	
	public List<T> list(String sql);//or hql and so on
	
	public int getTotalCount(String sql,Object... params);
	
	public List<T> list(String sql,int first,int max,Object... params);

}
