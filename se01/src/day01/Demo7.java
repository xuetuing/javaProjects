package day01;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo7 {
/*
 * ������
 * "�Ϻ�����ˮ���Ժ���"  "ɽ����ú��ú����ɽ"
 * ����̨�����ַ������ж��Ƿ�Ϊ����
 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ַ�����");
		String str = sc.next();
		judge(str);
//		if(){
//			System.out.println("�ǻ��ģ�");
//		}else{
//			System.out.println("���ǻ��ģ�");
//		}
	}
	
//	public static boolean judge(String str) throws UnsupportedEncodingException{
//		byte[] gbk = str.getBytes("GBK");
//		for(int i=0;i<=gbk.length/2;i++){
//			if(gbk[i]!=gbk[gbk.length-1-i]){
//				return false;
//			}
//			if(i==gbk.length/2){
//				return true;
//			}
//		}
//		return false;
//	}
	//public static boolean judge(String str){
	public static void judge(String str){	
//		char[] s = str.toCharArray();
//		System.out.println(s[0]);
//		for(int i=0;i<=s.length/2;i++){
//			if(s[i]!=s[s.length-1-i]){
//				return false;
//			}
//			if(i==s.length/2){
//				return true;
//			}
//		}
//		return false;
		for(int i=0;i<=str.length()/2;i++){
			if(str.charAt(i) != str.charAt(str.length()-1-i)){
				System.out.println("���ǻ���");
				return;
			}
		}
		System.out.println("�ǻ���");
	}
}







