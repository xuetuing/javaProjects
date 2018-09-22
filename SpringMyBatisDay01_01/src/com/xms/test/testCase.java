package com.xms.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.entity.ExampleBean;
import com.xms.entity.User;

public class testCase {
	
	//Spring 容器的实例化
	@Test
	public void testOne(){
		String xml = "spring.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(xml);
		
		User user = (User) ac.getBean("user");
		System.out.println(ac);
		System.out.println(user);
		
		Calendar calendar = Calendar.getInstance();//getInstance()是静态工厂方法
		Date data = calendar.getTime(); //getTime()是实例化工厂方法
		
	}
	//实例化Bean方式
	@Test
	public void testTwo(){
		//实例化容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		//1.直接用构造器
		Calendar c1 = (Calendar) ac.getBean("gregorianCalendar");
		//System.out.println(c1);
		//利用静态工厂方法
		Calendar c2 = ac.getBean("calendar",Calendar.class);
		//System.out.println(c2);
		//实例化工厂方法
		Date d1 = ac.getBean("date",Date.class);
		System.out.println(d1);
		
	}
	@Test
	public void testThree(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		
		User one = ac.getBean("user",User.class);
		User two = ac.getBean("userOne",User.class);
		
		System.out.println(one);
		System.out.println(two);
		System.out.println(one == two);//false
		
		User three = ac.getBean("userOne", User.class);
		System.out.println(two == three); //true 默认单例模式
		
		User four = ac.getBean("userTwo", User.class);
		User five = ac.getBean("userTwo", User.class);
		System.out.println(four == five); //false 声明了非单例  prototype
		
	}
	//Bean对象的生命周期
	@Test
	public void testFour(){
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("spring.xml");
		ExampleBean exampleBean = aac.getBean("exampleBean",ExampleBean.class);
		
		aac.close();
	}
	
}









