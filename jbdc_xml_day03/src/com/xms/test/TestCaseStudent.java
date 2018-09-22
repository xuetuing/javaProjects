package com.xms.test;

import org.junit.Test;

import com.xms.dao.StudentDao;
import com.xms.dao.impl.StudentDaoImpl;

public class TestCaseStudent {
	StudentDao dao = new StudentDaoImpl();
	@Test
	public void testStudent(){
		//dao.saveBatch();
		dao.deleteBatch();
	}
	
}
