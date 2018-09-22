package com.xms.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Autowired
	@Qualifier("com")
	private Computer computer;
	
	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		System.out.println("我是student");
		this.computer = computer;
	}
	
	
}	
