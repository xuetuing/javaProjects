package com.xms.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Programmer {
	private Computer computer;
	
	public Programmer(){}
	@Autowired
	public Programmer(@Qualifier("com")Computer computer) {
		this.computer = computer;
	}
	//单独使用的情况下，默认是按类型装配
//	@Autowired
//	public Programmer(Computer computer) {
//		this.computer = computer;
//	}
	public Computer getComputer() {
		return computer;
	}
	
	
}
