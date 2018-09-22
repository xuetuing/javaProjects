package com.xms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xms.entity.User;

@Controller
@RequestMapping("/test")
public class TestController {
	
	//返回单个值
	//基本数据类型值：undefined,Null,Boolean,Number,String
	@RequestMapping("testOne.do")
	@ResponseBody
	public Integer testOne(){
		return 5;
	}
	@RequestMapping("testTwo.do")
	@ResponseBody
	public Map<String,Object> testTwo(){
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("id", 1001);
		data.put("name", "张三");
		
		return data;
	}
	@RequestMapping("testThree.do")
	@ResponseBody
	public List<String> testThree(){
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		return list;
	}
	@RequestMapping("testFour.do")
	@ResponseBody
	public User testFour(){
		User user = new User();
		user.setId(1001);
		user.setName("赵云");
		user.setObj(true);
		return user;
	}
	@RequestMapping("testFive.do")
	@ResponseBody
	public List<User> testFive(){
		List<User> users = new ArrayList<User>();
		User one = new User();
		one.setId(1001);
		one.setName("赵云");
		
		User two = new User();
		two.setId(1002);
		two.setName("赵虎");
		users.add(one);
		users.add(two);
		
		return users;
	}
	
}
