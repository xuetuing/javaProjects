package day01;

import java.io.File;
import java.io.IOException;

//创建多层目录、创建文件
public class FileDemo3 {
	public static void main(String[] args) throws IOException {
		//创建多层目录
//		File dir = new File("a"+File.separator+"b"+File.separator+"c");
//		if(!dir.exists()){
//			dir.mkdirs();
//		}
//		File file = new File("demo.txt");
//		if(!file.exists()){
//			file.createNewFile();
//		}
//		System.out.println("创建成功");
		
		File dir = new File("demo");
		/*
		 * File(File dir,String fileName)
		 * 在给定的File对象所描述的目录中表示给定名字的文件或目录
		 */
		File file1 = new File(dir,"demo.txt"); //File file1 = new File("demo","demo.txt");
		if(!file1.exists()){
			file1.createNewFile();
		}
		System.out.println("创建完毕");
		
		
	}
}



















