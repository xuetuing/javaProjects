package day03;

import java.util.Scanner;
public class Demo7 {
	public static void main(String [] args){
//		int a = 600;
//		int b = a>=5 ? 400/3 : 605%10;
//		System.out.println(b);
		//���ݲ�ѯ�����������ҳ���С�������ѯ�����ҳ��
		//����̨�������ѯ���������rows, size=10
		Scanner sc = new Scanner(System.in);
		System.out.print("please input a rows:");
		int rows = sc.nextInt();
		int size = 10;
		int pages = rows%size == 0 ? rows/size : (rows/size + 1);
		System.out.println("There are " + pages + " pages.");
		
	}
}
