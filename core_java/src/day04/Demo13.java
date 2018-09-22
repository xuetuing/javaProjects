package day04;

import java.util.Scanner;

public class Demo13 {
	public static void main(String[] args) {
		/*
		 * 1.控制台输入税前薪资
		 * 2.<3500    不交税
		 *   3500~5000  3%
		 *   5000~8000  10%
		 *   8000~12500 20%
		 *   其他情况            30%
		 *   salary   income   tax
		 *   salaryIncome = salary - 3500
		 *   tax? income? 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("输入税前薪资：");
		double salary = sc.nextDouble();
		double income,tax;
		if(salary>12500){
			tax = (salary-12500)*0.3 + 4500*0.2 + 3000*0.1 + 1500*0.03; 
		}else if(salary>8000){
			tax = (salary-8000)*0.2 + 3000*0.1 + 1500*0.03;
		}else if(salary>5000){
			tax = (salary-5000)*0.1 + 1500*0.03;
		}else if(salary>3500){
			tax = (salary-3500)*0.03;
		}else{
			tax = 0;
		}
		income = salary - tax;
		System.out.println("缴税为："+tax);
		System.out.println("税后个人收入为："+income);
		
	}
}
