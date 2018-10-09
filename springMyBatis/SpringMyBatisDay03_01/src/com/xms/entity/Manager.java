package com.xms.entity;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Manager {
	private Computer computer;

	public Computer getComputer() {
		return computer;
	}
	@Resource(name="com")
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	
}
