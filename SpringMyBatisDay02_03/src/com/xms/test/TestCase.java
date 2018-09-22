package com.xms.test;

import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.entity.DemoBean;
import com.xms.entity.TestDemo;

public class TestCase {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	
	@Test
	public void testOne(){
		TestDemo testDemo = ac.getBean("testDemo",TestDemo.class);
		
		System.out.println("基本值：");
		System.out.println(testDemo.getId());
		System.out.println(testDemo.getName());
		
		System.out.println("Bean对象:");
		if(testDemo.getUser() != null){
			System.out.println(testDemo.getUser().getId());
			System.out.println(testDemo.getUser().getName());
		}
		System.out.println("编程语言:");
		if(testDemo.getLanguages() != null){
			for(String language : testDemo.getLanguages())
			System.out.println(language);
		}
		
		System.out.println("城市:");
		if(testDemo.getCities() != null){
			for(String city : testDemo.getCities()){
				System.out.println(city);
			}
		}
		
		System.out.println("分数:");
		if(testDemo.getScores() != null){
			Set<String> keys = testDemo.getScores().keySet();
			for(String key : keys){
				System.out.println(key+":"+testDemo.getScores().get(key));
			}
		}
		System.out.println("参数:");
		if(testDemo.getProperties() != null){
			Set<Object> keys = testDemo.getProperties().keySet();
			for(Object key : keys){
				System.out.println(key+":"+testDemo.getProperties().getProperty(key.toString()));
			}
		}
		
	}
	
	@Test
	public void testTwo(){

		TestDemo testDemoOne = ac.getBean("testDemoOne",TestDemo.class);
		
		System.out.println("Bean对象:");
		if(testDemoOne.getUser() != null){
			System.out.println(testDemoOne.getUser().getId());
			System.out.println(testDemoOne.getUser().getName());
		}
		System.out.println("编程语言:");
		if(testDemoOne.getLanguages() != null){
			for(String language : testDemoOne.getLanguages())
			System.out.println(language);
		}
		
		System.out.println("城市:");
		if(testDemoOne.getCities() != null){
			for(String city : testDemoOne.getCities()){
				System.out.println(city);
			}
		}
		
		System.out.println("分数:");
		if(testDemoOne.getScores() != null){
			Set<String> keys = testDemoOne.getScores().keySet();
			for(String key : keys){
				System.out.println(key+":"+testDemoOne.getScores().get(key));
			}
		}
		System.out.println("参数:");
		if(testDemoOne.getProperties() != null){
			Set<Object> keys = testDemoOne.getProperties().keySet();
			for(Object key : keys){
				System.out.println(key+":"+testDemoOne.getProperties().getProperty(key.toString()));
			}
		}
		
	
	}
	@Test
	public void testThree(){
		DemoBean demoBean = ac.getBean("demoBean",DemoBean.class);
		System.out.println(demoBean.getName());
		System.out.println(demoBean.getCity());
		System.out.println(demoBean.getLanguage());
		System.out.println(demoBean.getScore());
		System.out.println(demoBean.getPageSize());
	}

}
	
	
	
	
	
	
	
	
