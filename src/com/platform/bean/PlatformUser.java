package com.platform.bean;

public class PlatformUser extends BaseBean {
	
	private String nickname;
	private String avatar;
	private String identity_type;//��¼���ͣ��û������ֻ������䡢��������
	private String identifier;//�ֻ������䡢�û������������ȵ�Ψһid
	private String credential;//����or token
	private String randCredential;//��������� salt
	private int login_type;
	
	public int getLogin_type() {
		return login_type;
	}
	public void setLogin_type(int login_type) {
		this.login_type = login_type;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIdentity_type() {
		return identity_type;
	}
	public void setIdentity_type(String identity_type) {
		this.identity_type = identity_type;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getCredential() {
		return credential;
	}
	public void setCredential(String credential) {
		this.credential = credential;
	}
	public String getRandCredential() {
		return randCredential;
	}
	public void setRandCredential(String randCredential) {
		this.randCredential = randCredential;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
