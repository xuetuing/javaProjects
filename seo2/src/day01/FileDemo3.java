package day01;

import java.io.File;
import java.io.IOException;

//�������Ŀ¼�������ļ�
public class FileDemo3 {
	public static void main(String[] args) throws IOException {
		//�������Ŀ¼
//		File dir = new File("a"+File.separator+"b"+File.separator+"c");
//		if(!dir.exists()){
//			dir.mkdirs();
//		}
//		File file = new File("demo.txt");
//		if(!file.exists()){
//			file.createNewFile();
//		}
//		System.out.println("�����ɹ�");
		
		File dir = new File("demo");
		/*
		 * File(File dir,String fileName)
		 * �ڸ�����File������������Ŀ¼�б�ʾ�������ֵ��ļ���Ŀ¼
		 */
		File file1 = new File(dir,"demo.txt"); //File file1 = new File("demo","demo.txt");
		if(!file1.exists()){
			file1.createNewFile();
		}
		System.out.println("�������");
		
		
	}
}



















