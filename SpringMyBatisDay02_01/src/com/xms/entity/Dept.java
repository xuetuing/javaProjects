package com.xms.entity;

public class Dept {
	private Integer id;
	private String name;
	
	public Dept(){}
	public Dept(Integer id,String name){
		System.out.println(123);
		this.id = id;
		this.name = name;
	}
	public Dept(String id,String name){
		System.out.println(456);
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
}
