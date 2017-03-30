CREATE DATABASE IF NOT EXISTS hotchpotch CHARACTER SET utf8;

USE hotchpotch;

DROP TABLE IF EXISTS tb_platform_users;
DROP TABLE IF EXISTS tb_platform_users_auths;

CREATE TABLE tb_platform_users (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	nickname VARCHAR(45) NOT NULL UNIQUE,
	avatar VARCHAR(255) DEFAULT ''
);

CREATE TABLE tb_platform_users_auths (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	user_id INTEGER UNIQUE,
	identity_type TINYINT UNSIGNED DEFAULT 1 COMMENT '��¼���ͣ��û������ֻ������䡢��������',
	identifier VARCHAR(128) COMMENT '�ֻ������䡢�û������������ȵ�Ψһid',
	credential VARCHAR(255) NOT NULL COMMENT 'վ�������������token',
	randCredential VARCHAR(16) COMMENT 'վ�����������',
	FOREIGN KEY (user_id) REFERENCES tb_platform_users(id)
);