package day03;

import java.util.Scanner;
public class Demo7 {
	public static void main(String [] args){
//		int a = 600;
//		int b = a>=5 ? 400/3 : 605%10;
//		System.out.println(b);
		//根据查询结果的数量和页面大小，计算查询结果的页数
		//控制台输入你查询结果的数量rows, size=10
		Scanner sc = new Scanner(System.in);
		System.out.print("please input a rows:");
		int rows = sc.nextInt();
		int size = 10;
		int pages = rows%size == 0 ? rows/size : (rows/size + 1);
		System.out.println("There are " + pages + " pages.");
		
	}
}
