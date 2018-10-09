package day04;

import java.util.Scanner;
public class Demo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input two numbers:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		System.out.println(a+","+b);
	}
}
