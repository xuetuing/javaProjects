package day01;

import java.io.File;

//ɾ���ļ���Ŀ¼
public class FileDemo5 {
	public static void main(String[] args) {
		File file = new File("demo.txt");
		if(file.delete())
			System.out.println("ɾ���ļ����");
		else
			System.out.println("ssw");
		
		File dir = new File("demo");
		dir.delete(); //ǰ������:��Ŀ¼
		System.out.println("Ŀ¼ɾ�����");
		
	}
}
