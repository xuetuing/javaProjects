package testdemo.file;

import java.io.File;
import java.security.acl.LastOwnerException;

public class CopyFile {
	public static void main(String[] args) {
		File f = new File("D:/Test");
		File[] files = f.listFiles();
		File dest = null;
		System.out.println("开始复制...");
		for(File source : files){
			if(source.isFile()){
				String name = source.getName();
				dest = new File("D:/Test/test/"+name);
				try {
					Utils.copyFile(source, dest);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("复制完成");
	}
}
