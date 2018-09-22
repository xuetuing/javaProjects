package com.xms.dao;

public interface UserDao {
	//Statement 语句对象进行登录验证
	void loginByStatement(String user,String pwd);
	//PreparedStatement 语句对象进行登录验证
	void loginByPreparedStatement(String user,String pwd);
}
