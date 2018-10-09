package com.xms.test;

import org.junit.Test;

import com.xms.dao.AccountDao;
import com.xms.dao.impl.AccountDaoImpl;

public class TestCaseAccount {
	AccountDao  dao = new AccountDaoImpl();
	@Test
	public void testAccount(){
		dao.translate("B", "B", 500);
	}
}
