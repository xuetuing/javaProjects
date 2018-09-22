package day02;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		File dir = new File(".");
		System.out.println(dir.getCanonicalPath());
		if(dir.isDirectory()){
			/*
			 * String[] list()
			 * 获取当前目录下的所有的子项名字
			 */
			String[] subNames = dir.list();
			for(String sub : subNames){
				System.out.println(sub);
			}
			/*
			 * File[] listFiles()
			 * 获取当前目录下所有的子项
			 */
			File[] subs = dir.listFiles();
			for(File sub : subs){
				System.out.println(sub.isFile()?"文件":"目录");
				System.out.println(sub.getName());
				System.out.println(sub.length());
				System.out.println();
			}
			
		}
	}
}






