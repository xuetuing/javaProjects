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
		//������ȡ����SAXReader
		SAXReader reader = new SAXReader();
		try {
			//�����ĵ�����
			Document document = reader.read(new File("src/com/xms/xml/deptList.xml"));
			//��ȡ��Ԫ��
			Element root = document.getRootElement();
			//��ȡ��Ԫ���µ�ȫ����Ԫ��
			List<Element> elements = root.elements();
			//����Ԫ��
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
			//����deptList,��ӡ����
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
		deptList.add(new Dept(10,"�г���","����"));
		deptList.add(new Dept(20,"���۲�","�Ͼ�"));
		deptList.add(new Dept(30,"�з���","����"));
		
		//��������д����ĵ�����
		Document document = DocumentHelper.createDocument();
		//���ĵ���Ӹ�Ԫ��
		Element root = document.addElement("deptList");
		//����deptList�����Ԫ�����Ԫ��
		for (Dept dept : deptList) {
			Element element = root.addElement("dept");
			
			element.addAttribute("deptno", dept.getDeptno()+"");
			element.addElement("danme").addText(dept.getDname()); 
			element.addElement("location").addText(dept.getLocation()); 
		}
		//д����XML�ļ�
		try {
			//����XMLWriter����
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











