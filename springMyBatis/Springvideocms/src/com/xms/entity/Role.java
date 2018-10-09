package com.xms.entity;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	
	private List<Privilege> privs;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Privilege> getPrivs() {
		return privs;
	}
	public void setPrivs(List<Privilege> privs) {
		this.privs = privs;
	}
	
	
}
