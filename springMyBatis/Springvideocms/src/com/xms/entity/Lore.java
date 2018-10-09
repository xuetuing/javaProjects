package com.xms.entity;

import java.io.Serializable;

public class Lore implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer course_id;
	
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
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer courseId) {
		course_id = courseId;
	}
	
	
}
