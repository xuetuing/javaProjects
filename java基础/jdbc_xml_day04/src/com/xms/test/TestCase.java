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
		//����SAX����
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File("src/com/xms/xml/studentList.xml"));
			//��ȡ��Ԫ��
			Element root = document.getRootElement();
			//��ȡȫ��Ԫ��
			List<Element> elements = root.elements();
			//����Ԫ��
			List<Student> stuList = new ArrayList<Student>();
			for (Element element : elements) {
				//ȡ��Ԫ�ص�����
				int id = Integer.parseInt(element.attribute("id").getValue());
				String name = element.elementText("name");
				int age = Integer.parseInt(element.elementText("age"));
				int money = Integer.parseInt(element.elementText("money"));
			//��װ����
			Student stu = new Student(id,name,age,money);
			//��������ӵ�����
			stuList.add(stu);
			}
			//������ӡ����
			for (Student stu : stuList) {
				System.out.println(stu.getId()+","+stu.getName()+","+stu.getAge()+","+stu.getMoney());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testWrite(){
		//��������
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(001,"������",25,1000));
		students.add(new Student(002,"����",27,3000));
		students.add(new Student(003,"����",21,5000));
		//����Document����
		Document document = DocumentHelper.createDocument();
		//��Ӹ�Ԫ��
		Element root = document.addElement("studentList");
		//����������ӵ���Ԫ����
		for (Student student : students) {
			//��Ԫ�������Ԫ��
			Element element = root.addElement("stu");
			//����Ԫ���������
			element.addAttribute("id",student.getId()+"");
			element.addElement("name").addText(student.getName());
			element.addElement("age").addText(student.getAge()+"");
			element.addElement("money").addText(student.getMoney()+"");
			
		}
		//д��XML �ļ�
		
		try {
			XMLWriter writer = new XMLWriter();
			FileOutputStream fos = new FileOutputStream("src/com/xms/xml/stuList.xml");
			//�ļ�����ʽд����ָ���ļ�
			writer.setOutputStream(fos);
			//documentд�뵽XMLWriter
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}















