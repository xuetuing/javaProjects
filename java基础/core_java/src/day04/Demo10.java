package day04;

import java.util.Random;

public class Demo10 {
	public static void main(String[] args) {
		Random rd = new Random();
		int a;
		int b;
//		do{
//			a= new Random().nextInt(8);
//			b= new Random().nextInt(8);
//		}while(a*a+b*b != 50);
		do{
			a= rd.nextInt(8);
			b= rd.nextInt(8);
		}while(a*a+b*b != 50);
		System.out.println("找到了两个数："+a+","+b);
	}
}
