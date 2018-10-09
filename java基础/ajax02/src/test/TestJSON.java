package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import entity.User;

public class TestJSON {
	@Test
	public void test1(){
		User u1 = new User("张三",10);
		String data = JSONObject.fromObject(u1).toString();
		System.out.println(data);
	}
	@Test
	public void test2(){
		User u1 = new User("张三",10);
		User u2 = new User("李四",20);
		
		User[] us = {u1,u2};
		
		String data = JSONArray.fromObject(us).toString();
		System.out.println(data);
	}
	@Test
	public void test3(){
		User u1 = new User("张三",10);
		User u2 = new User("李四",20);
		
		List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		
		String data = JSONArray.fromObject(list).toString();
		System.out.println(data);
	}
	@Test
	public void test4(){
		User u1 = new User("张三",10);
		User u2 = new User("李四",20);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("u1",u1);
		map.put("u2",u2);
		
		String data = JSONObject.fromObject(map).toString();
		System.out.println(data);
//		String data = JSONArray.fromObject(map).toString();
//		System.out.println(data);
	}
	
}

















