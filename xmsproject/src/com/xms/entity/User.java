package com.xms.entity;

import java.util.Date;
import org.springframework.stereotype.Component;

public class User {
	private Integer id;
	private String email;
	private String nickname;
	private String password;
	private Date registedate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegistedate() {
		return registedate;
	}
	public void setRegistedate(Date registedate) {
		this.registedate = registedate;
	}
	
	
	
}
