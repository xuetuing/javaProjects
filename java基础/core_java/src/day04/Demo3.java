package day04;

import java.util.Scanner;
public class Demo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input your years:");
		int years = sc.nextInt();
		double base = 0.077;
		double rate; //rate = base;
		if(years<=1){
			rate = base*0.5*100; //此处对rate进行操作
		}else if(years>1 && years<=3){
			rate = base*0.7*100;
		}else if(years>3 && years<=5){
			rate = base*1*100;			
		}else{
			rate = base*1.1*100;
		}
		System.out.println("the fact rate is: "+rate+"%");
		
	}
}
