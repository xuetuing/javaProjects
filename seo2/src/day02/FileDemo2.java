package day02;

import java.io.File;

//将给定的File对象所表示的文件或目录删除
public class FileDemo2 {
	public static void main(String[] args) {
		delete(new File("g"));
	}
	
	public static void delete(File file){
//		File[] subs = file.listFiles();
//		if(subs.length != 0){
//			for(File sub : subs){
//				
//				if(sub.isDirectory()){
//					System.out.println(sub.getName());
//					delete(sub);
//				}else{
//					System.out.println(sub.getName());
//					sub.delete();
//				}
//			}
//		}
//		for(File sub : subs){
//			if(!sub.delete())
//				delete(sub);
//		}
//		file.delete();
		
		if(file==null || !file.exists()){
			System.out.println("文件或目录不存在");
		}
		if(file.isFile()){
			file.delete();
			return;
		}
		File[] subs = file.listFiles();
		for(File sub : subs){
			delete(sub);
		}
		file.delete();
		System.out.println("文件删除成功");
		
	}
	
	
	
	
	
	
	
	
	
}
