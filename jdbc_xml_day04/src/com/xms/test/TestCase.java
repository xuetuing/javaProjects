package com.xms.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import com.xms.entity.Student;

public class TestCase {
	@Test
	public void testRead(){
		//创建SAX对象
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File("src/com/xms/xml/studentList.xml"));
			//获取根元素
			Element root = document.getRootElement();
			//获取全部元素
			List<Element> elements = root.elements();
			//遍历元素
			List<Student> stuList = new ArrayList<Student>();
			for (Element element : elements) {
				//取子元素的数据
				int id = Integer.parseInt(element.attribute("id").getValue());
				String name = element.elementText("name");
				int age = Integer.parseInt(element.elementText("age"));
				int money = Integer.parseInt(element.elementText("money"));
			//封装对象
			Student stu = new Student(id,name,age,money);
			//将对象添加到集合
			stuList.add(stu);
			}
			//遍历打印数据
			for (Student stu : stuList) {
				System.out.println(stu.getId()+","+stu.getName()+","+stu.getAge()+","+stu.getMoney());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testWrite(){
		//构造数据
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(001,"张三丰",25,1000));
		students.add(new Student(002,"张三",27,3000));
		students.add(new Student(003,"李四",21,5000));
		//创建Document对象
		Document document = DocumentHelper.createDocument();
		//添加根元素
		Element root = document.addElement("studentList");
		//遍历数据添加到根元素中
		for (Student student : students) {
			//根元素中添加元素
			Element element = root.addElement("stu");
			//给子元素添加属性
			element.addAttribute("id",student.getId()+"");
			element.addElement("name").addText(student.getName());
			element.addElement("age").addText(student.getAge()+"");
			element.addElement("money").addText(student.getMoney()+"");
			
		}
		//写出XML 文件
		
		try {
			XMLWriter writer = new XMLWriter();
			FileOutputStream fos = new FileOutputStream("src/com/xms/xml/stuList.xml");
			//文件流方式写出到指定文件
			writer.setOutputStream(fos);
			//document写入到XMLWriter
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}















