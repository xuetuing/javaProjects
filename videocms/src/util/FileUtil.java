package util;

import java.io.File;

public class FileUtil {
	//删除文件
	public static void delFile(File f){
		if(f.exists()&&f.isFile()){
			f.delete();
		}
	}
	
	//删除文件夹
	public static void delDir(File f){
		if(f.exists()&&f.isDirectory()){
			File[] files = f.listFiles();
			for(File fi : files){
				if(fi.isFile()){
					fi.delete();
				}else if(fi.isDirectory()){
					delDir(fi);
				}
			}
			f.delete();
		}
	}
}
