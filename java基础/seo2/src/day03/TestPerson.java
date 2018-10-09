package day03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestPerson {
	public static void main(String[] args) throws Exception{
		//使用ObjectOutputStream进行对象的序列化
		Person person = new Person("张三丰",18,1);
		FileOutputStream fos =
			new FileOutputStream("person.obj");//固有格式
		ObjectOutputStream oos =
			new ObjectOutputStream(fos);
		oos.writeObject(person);
		oos.close();
		//使用ObjectInputStream进行对象的反序列化
		FileInputStream fis =
			new FileInputStream("person.obj");
		ObjectInputStream ois =
			new ObjectInputStream(fis);
		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();
	}
}
