package day02;

import java.io.File;

//��������File��������ʾ���ļ���Ŀ¼ɾ��
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
			System.out.println("�ļ���Ŀ¼������");
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
		System.out.println("�ļ�ɾ���ɹ�");
		
	}
	
	
	
	
	
	
	
	
	
}
