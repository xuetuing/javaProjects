package com.xms.dao;

public interface UserDao {
	//Statement ��������е�¼��֤
	void loginByStatement(String user,String pwd);
	//PreparedStatement ��������е�¼��֤
	void loginByPreparedStatement(String user,String pwd);
}
