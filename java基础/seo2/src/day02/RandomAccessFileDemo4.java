package day02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

//将控制台输入的内容写入文件
public class RandomAccessFileDemo4 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		System.out.print("请输入内容：");
//		String str = sc.next();
//		
//		RandomAccessFile raf = new RandomAccessFile("test.dat","rw");
//		raf.writeUTF(str);
//		char ch;
//		while(true){
//			System.out.println("是否要继续输入(y/n)：");
//			ch = sc.next().charAt(0);
//			if(ch == 'y'){
//				System.out.println("请输入内容：");
//				str = sc.next();
//				raf.writeUTF(str);
//			}else{
//				break;
//			}
//		}
//		raf.close();
//		String str;
//		char ch;
//		RandomAccessFile raf = new RandomAccessFile("test.dat","rw");
//		do{
//			System.out.println("请输入内容：");
//			str = sc.next();
//			raf.writeUTF(str);
//			
//			System.out.println("是否要继续输入(y/n)：");
//			ch = sc.next().charAt(0);
//			
//		}while(ch=='n');
		/*
		 * 若开始就将RandomAccessFile的游标移动到文件
		 * 的末尾，则是追加内容，否则新写入的内容会覆盖之前内容
		 */
		
		RandomAccessFile raf = new RandomAccessFile("test.dat","rw");
		raf.seek(raf.length());
		System.out.println("请输入内容：");
		
		while(true){
			String str = sc.nextLine();
			if("exit".equals(str)){
				break;
			}
			raf.writeUTF(str);
			System.out.println("请输入内容：");	//加入提示语后，输入很容易出现问题
		}
		System.out.println("谢谢使用");	
		raf.close();
				
	}
}

































