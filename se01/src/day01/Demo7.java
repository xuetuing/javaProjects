package day01;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo7 {
/*
 * 检查回文
 * "上海自来水来自海上"  "山西运煤车煤运西山"
 * 控制台输入字符串，判断是否为回文
 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);
		System.out.print("输入字符串：");
		String str = sc.next();
		judge(str);
//		if(){
//			System.out.println("是回文！");
//		}else{
//			System.out.println("不是回文！");
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
				System.out.println("不是回文");
				return;
			}
		}
		System.out.println("是回文");
	}
}







