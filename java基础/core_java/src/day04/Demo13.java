package day04;

import java.util.Scanner;

public class Demo13 {
	public static void main(String[] args) {
		/*
		 * 1.����̨����˰ǰн��
		 * 2.<3500    ����˰
		 *   3500~5000  3%
		 *   5000~8000  10%
		 *   8000~12500 20%
		 *   �������            30%
		 *   salary   income   tax
		 *   salaryIncome = salary - 3500
		 *   tax? income? 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("����˰ǰн�ʣ�");
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
		System.out.println("��˰Ϊ��"+tax);
		System.out.println("˰���������Ϊ��"+income);
		
	}
}
