package day02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

//������̨���������д���ļ�
public class RandomAccessFileDemo4 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		System.out.print("���������ݣ�");
//		String str = sc.next();
//		
//		RandomAccessFile raf = new RandomAccessFile("test.dat","rw");
//		raf.writeUTF(str);
//		char ch;
//		while(true){
//			System.out.println("�Ƿ�Ҫ��������(y/n)��");
//			ch = sc.next().charAt(0);
//			if(ch == 'y'){
//				System.out.println("���������ݣ�");
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
//			System.out.println("���������ݣ�");
//			str = sc.next();
//			raf.writeUTF(str);
//			
//			System.out.println("�Ƿ�Ҫ��������(y/n)��");
//			ch = sc.next().charAt(0);
//			
//		}while(ch=='n');
		/*
		 * ����ʼ�ͽ�RandomAccessFile���α��ƶ����ļ�
		 * ��ĩβ������׷�����ݣ�������д������ݻḲ��֮ǰ����
		 */
		
		RandomAccessFile raf = new RandomAccessFile("test.dat","rw");
		raf.seek(raf.length());
		System.out.println("���������ݣ�");
		
		while(true){
			String str = sc.nextLine();
			if("exit".equals(str)){
				break;
			}
			raf.writeUTF(str);
			System.out.println("���������ݣ�");	//������ʾ�����������׳�������
		}
		System.out.println("ллʹ��");	
		raf.close();
				
	}
}

































