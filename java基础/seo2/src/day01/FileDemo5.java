package day01;

import java.io.File;

//删除文件或目录
public class FileDemo5 {
	public static void main(String[] args) {
		File file = new File("demo.txt");
		if(file.delete())
			System.out.println("删除文件完毕");
		else
			System.out.println("ssw");
		
		File dir = new File("demo");
		dir.delete(); //前提条件:空目录
		System.out.println("目录删除完毕");
		
	}
}
