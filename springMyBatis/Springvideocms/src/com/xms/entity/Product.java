package com.xms.entity;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;//�γ����
	private Integer course_id;//�γ̷���
	private Integer lore_id;//�γ�����
	private String discription;
	private String status;
	private double price;
	private String image;
	private String video;
	private String creater;
	private Date createtime;
	
	//�γ�
	private Course c;
	
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
	public Integer getLore_id() {
		return lore_id;
	}
	public void setLore_id(Integer loreId) {
		lore_id = loreId;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Course getC() {
		return c;
	}
	public void setC(Course c) {
		this.c = c;
	}
	
	
	
}
