package Test;

import java.util.Scanner;

public class Hight {
	public static void main(String[] args) {
		double hight = 100;
		double sum = hight;
		Scanner sc = new Scanner(System.in);
		System.out.print("���뷴��������");
		int count = sc.nextInt();
		for(int i=1;i<=count;i++){
			hight /= 2;  //��һ�η����߶�
			if(count <= 9){
				sum += hight*2; //�ڶ������	
			}			
		}
		System.out.println("��ʮ�η����߶�Ϊ��"+hight);
		System.out.println("��ʮ�������·��Ϊ��"+sum);
	}
}
