package com.xms.entity;

public class Company {
	private Emp emp;
	private Dept dept;
	
	
	public Company(Emp emp, Dept dept) {
		this.emp = emp;
		this.dept = dept;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Emp getEmp() {
		return emp;
	}
	public Dept getDept() {
		return dept;
	}
	
	
}
