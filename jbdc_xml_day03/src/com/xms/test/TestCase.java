package com.xms.test;

import org.junit.Test;

import com.xms.dao.UserDao;
import com.xms.dao.impl.UserDaoImpl;

public class TestCase {
	UserDao dao = new UserDaoImpl();
	@Test
	public void testStatement(){
		//正确的用户名和密码
		//dao.loginByStatement("张三", "666666");
		//正确的用户名和伪造的密码，'a'or'1'='1'
		dao.loginByStatement("张三", "a'or'1'='1");//存在ＳＱＬ注入问题，不安全
	}
	@Test
	public void testPreStatement(){
//		dao.loginByPreparedStatement("张三", "666666");
		
		dao.loginByPreparedStatement("张三", "'a'or'1'='1'");
	}
	
}
