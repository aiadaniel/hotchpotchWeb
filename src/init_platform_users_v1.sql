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
	identity_type TINYINT UNSIGNED DEFAULT 1 COMMENT '登录类型，用户名、手机、邮箱、第三方等',
	identifier VARCHAR(128) COMMENT '手机、邮箱、用户名、第三方等的唯一id',
	credential VARCHAR(255) NOT NULL COMMENT '站内密码或者三方token',
	randCredential VARCHAR(16) COMMENT '站内密码随机数',
	FOREIGN KEY (user_id) REFERENCES tb_platform_users(id)
);