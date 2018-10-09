package day03;

import java.util.Scanner;
public class Demo5 {
	public static void main(String[] args){
//		char c = 'a';
//		if(c >= 'A' && c <= 'Z'){
//			System.out.println(c + " is a upper word.");
//		}else{
//			System.out.println(c + " not a upper word.");
//		}
//		c = '中';
//		if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
//			System.out.println(c + " is a English word.");
//		}else{
//			System.out.println(c + " not a English word.");
//		}
		boolean flg = true;
		while(flg){
			Scanner sc = new Scanner(System.in); //控制台输入类
			System.out.println("please input a year:");
			int year = sc.nextInt();
			if((year%4 == 0 && year%100 != 0) || (year%400 == 0)){
				System.out.println(year + " is a run year.");
			}else{
				System.out.println(year + " not a run year.");			
				flg = false;
			}
		}
	}
}
