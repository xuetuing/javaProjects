package com.xms.test;

import org.junit.Test;

import com.xms.dao.UserDao;
import com.xms.dao.impl.UserDaoImpl;

public class TestCase {
	UserDao dao = new UserDaoImpl();
	@Test
	public void testStatement(){
		//��ȷ���û���������
		//dao.loginByStatement("����", "666666");
		//��ȷ���û�����α������룬'a'or'1'='1'
		dao.loginByStatement("����", "a'or'1'='1");//���ڣӣѣ�ע�����⣬����ȫ
	}
	@Test
	public void testPreStatement(){
//		dao.loginByPreparedStatement("����", "666666");
		
		dao.loginByPreparedStatement("����", "'a'or'1'='1'");
	}
	
}
