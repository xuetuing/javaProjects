package day04;

import java.util.Scanner;
import java.math.*;

public class Demo8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input a num:");
		int num = sc.nextInt();
		//int num1 = num;
		int last;
		//int cout = 0;
//		while(num != 0){
//			last = num%10;
//			num /= 10;
//			System.out.print(last);
//		}
//		int cout=0;
//		int newNum = 0;
//		while(num != 0){
//			num /= 10;
//			cout++;
//		}
//		System.out.println(cout);
//		while(num1 != 0){
//			last = num1%10;
//			num1 /= 10;
//			newNum += last*Math.pow(10,--cout);
//		}
//		System.out.println(newNum);
		int newNum = 0;
		while(num != 0){
			last = num%10;
			num /= 10;
			newNum = newNum*10+last;
		}
		System.out.println(newNum);
	}
}
