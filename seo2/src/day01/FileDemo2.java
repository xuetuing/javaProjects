package day01;

import java.io.File;

//ʹ��File���󴴽�Ŀ¼
public class FileDemo2 {
	public static void main(String[] args) {
		/*
		 * �ڵ�ǰĿ¼�´���һ��demoĿ¼
		 * .\demo �ɼ�дΪ  "demo",Ĭ�ϵ�ǰĿ¼
		 */
		File dir = new File("demo");
		System.out.println(dir.exists());
		if(!dir.exists()){
			dir.mkdir(); //����dir������Ŀ¼
		}
		System.out.println("�����ɹ�");
		
		
	}
}
