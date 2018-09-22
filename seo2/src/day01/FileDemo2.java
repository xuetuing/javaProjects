package day01;

import java.io.File;

//使用File对象创建目录
public class FileDemo2 {
	public static void main(String[] args) {
		/*
		 * 在当前目录下创建一个demo目录
		 * .\demo 可简写为  "demo",默认当前目录
		 */
		File dir = new File("demo");
		System.out.println(dir.exists());
		if(!dir.exists()){
			dir.mkdir(); //创建dir描述的目录
		}
		System.out.println("创建成功");
		
		
	}
}
