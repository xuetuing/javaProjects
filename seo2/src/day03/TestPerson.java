package day03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestPerson {
	public static void main(String[] args) throws Exception{
		//ʹ��ObjectOutputStream���ж�������л�
		Person person = new Person("������",18,1);
		FileOutputStream fos =
			new FileOutputStream("person.obj");//���и�ʽ
		ObjectOutputStream oos =
			new ObjectOutputStream(fos);
		oos.writeObject(person);
		oos.close();
		//ʹ��ObjectInputStream���ж���ķ����л�
		FileInputStream fis =
			new FileInputStream("person.obj");
		ObjectInputStream ois =
			new ObjectInputStream(fis);
		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();
	}
}
