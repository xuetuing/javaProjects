package com.xms.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestDemo {
	//基本值
	private Integer id;
	private String name;
	
	//Bean对象
	private User user;
	
	//集合
	private List<String> languages;
	private Set<String> cities;
	private Map<String,Object> scores;
	private Properties Properties;
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public Set<String> getCities() {
		return cities;
	}
	public void setCities(Set<String> cities) {
		this.cities = cities;
	}
	public Map<String, Object> getScores() {
		return scores;
	}
	public void setScores(Map<String, Object> scores) {
		this.scores = scores;
	}
	public Properties getProperties() {
		return Properties;
	}
	public void setProperties(Properties properties) {
		Properties = properties;
	}
	
	
}
