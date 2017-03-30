package com.platform.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.platform.bean.PlatformUser;
import com.platform.dao.IDao;
import com.platform.utils.DBManager;
import com.platform.utils.ErrCodeBase;

public class PlatformUserDao<T extends PlatformUser> implements IDao<T> {

	
	@Override
	public T find(Class<T> clazz, int id){
		return null;
	}

	// note: clazz这种方式更多是面向orm框架的抽象设计，传统jdbc一般不是这样设计
	@SuppressWarnings("unchecked")
	@Override
	public T find(Class<T> clazz, String nickname) {
		//todo: adjust login type
		String sql = "SELECT * FROM tb_platform_users_auths WHERE identifier = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, nickname);

			rs = statement.executeQuery();

			if (rs.next()) {
				PlatformUser user = new PlatformUser();
				user.setIdentifier(rs.getString("identifier"));
				user.setCredential(rs.getString("credential"));
				user.setRandCredential(rs.getString("randCredential"));
				user.setLogin_type(rs.getInt("identity_type"));
				user.setId(rs.getInt("user_id"));
				return (T) user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	
	//思考：TODO: 同时要插入两个表，如何处理事务才可靠？
	@Override
	public int create(T basebean) {
		//insert into
		String sql = "INSERT INTO tb_platform_users (nickname) VALUES (?)";
		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement statementAuths = null;
		ResultSet rs = null;
		ResultSet rsAuth = null;
		int id = -1;
		try {
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//need to add flag for get id
			statement.setString(1, basebean.getNickname());
			
			//add transaction support
			connection.setAutoCommit(false);

			statement.executeUpdate();
			
			//get id from table users
			rs = statement.getGeneratedKeys();
			rs.next();
			id = rs.getInt(1);
			
			if (id <= 0) {
				connection.rollback();//we need to ensure these two tables all insert success
				return ErrCodeBase.ERR_SQL;
			}
			
			
			String sql2 = "INSERT INTO tb_platform_users_auths (user_id,identity_type,identifier,credential,randCredential) VALUES (?,?,?,?,?)";
			statementAuths = connection.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
			statementAuths.setInt(1, id);
			statementAuths.setInt(2, basebean.getLogin_type());
			statementAuths.setString(3, basebean.getIdentifier());
			statementAuths.setString(4, basebean.getCredential());
			statementAuths.setString(5, basebean.getRandCredential());
			
			statementAuths.executeUpdate();
			
			rsAuth = statementAuths.getGeneratedKeys();
			rsAuth.next();
			int tempid = rsAuth.getInt(1);
			
			if (tempid <=0) {
				connection.rollback();
				return ErrCodeBase.ERR_SQL;
			}
			
			connection.commit();
			connection.setAutoCommit(true);//resume
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
				if (statementAuths != null)
					statementAuths.close();
				if (rsAuth != null)
					rsAuth.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
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

}
