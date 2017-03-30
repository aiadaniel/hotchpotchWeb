package com.platform.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.platform.bean.PlatformUser;
import com.platform.utils.Constant;
import com.platform.utils.ErrCodeBase;
import com.platform.utils.MD5Utils;

public class PlatformService<T extends PlatformUser> extends BaseService<T> {

	@SuppressWarnings("unchecked")
	@Override
	public int create(T basebean) {
		if (dao.find(null, basebean.getNickname())!= null ) {
			return ErrCodeBase.ERR_USER_ALREADY;
		}
		//first we need to generate salt for login by nickname
		if (basebean.getLogin_type()==Constant.LOGIN_NAME) {
			String salt = MD5Utils.generateRandString(6);
			String credential = basebean.getCredential() + salt;
			try {
				basebean.setCredential(MD5Utils.getEncryptedPwd(credential));
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			basebean.setRandCredential(salt);
			dao.create(basebean);
		}
		
		
		
		return ErrCodeBase.ERR_SUC;
	}
	
	//@Override
	public int find(PlatformUser user) {
		PlatformUser tempUser = (PlatformUser) dao.find(null, user.getNickname());
		if (tempUser == null) {
			return ErrCodeBase.ERR_URER_NOEXISTS;
		}
		//validate password
		try {
			String cre = MD5Utils.getEncryptedPwd(user.getCredential()+tempUser.getRandCredential());
			//System.out.println("1== " + cre);
			//System.out.println("2== " + tempUser.getCredential());
			if (user.getLogin_type()==Constant.LOGIN_NAME && 
					tempUser.getCredential().equals(cre) ) {
				return ErrCodeBase.ERR_SUC;
			}
			//other login type
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ErrCodeBase.ERR_FAIL;
		
	}

}
