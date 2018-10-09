package com.xms.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import com.xms.entity.Dept;

public class TestCaseDept {
	@Test
	public void testReadDept(){
		//创建读取对象SAXReader
		SAXReader reader = new SAXReader();
		try {
			//创建文档对象
			Document document = reader.read(new File("src/com/xms/xml/deptList.xml"));
			//获取根元素
			Element root = document.getRootElement();
			//获取根元素下的全部子元素
			List<Element> elements = root.elements();
			//遍历元素
			Dept dept = null;
			List<Dept> deptList = new ArrayList<Dept>();
			for (Element element : elements) {
				dept = new Dept();
				int deptno = Integer.parseInt(element.attribute("deptno").getValue());
				String dname = element.elementText("dname");
				String location = element.elementText("location");
				dept.setDeptno(deptno);
				dept.setDname(dname);
				dept.setLocation(location);
				
				deptList.add(dept);
			}
			//遍历deptList,打印数据
			for (Dept dep : deptList) {
				System.out.println(dep.getDeptno()+","+dep.getDname()+","+dep.getLocation());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testWriteDept(){
		List<Dept> deptList = new ArrayList<Dept>();
		deptList.add(new Dept(10,"市场部","广州"));
		deptList.add(new Dept(20,"销售部","南京"));
		deptList.add(new Dept(30,"研发部","苏州"));
		
		//创建用于写入的文档对象
		Document document = DocumentHelper.createDocument();
		//向文档添加根元素
		Element root = document.addElement("deptList");
		//遍历deptList，向根元素添加元素
		for (Dept dept : deptList) {
			Element element = root.addElement("dept");
			
			element.addAttribute("deptno", dept.getDeptno()+"");
			element.addElement("danme").addText(dept.getDname()); 
			element.addElement("location").addText(dept.getLocation()); 
		}
		//写出到XML文件
		try {
			//创建XMLWriter对象
			XMLWriter writer = new XMLWriter();
			
			FileOutputStream fos = new FileOutputStream("src/com/xms/xml/dept_List.xml");
			writer.setOutputStream(fos);
			writer.write(document);
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}











