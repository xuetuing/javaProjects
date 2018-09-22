package Test;

import java.util.Scanner;

public class Hight {
	public static void main(String[] args) {
		double hight = 100;
		double sum = hight;
		Scanner sc = new Scanner(System.in);
		System.out.print("输入反弹次数：");
		int count = sc.nextInt();
		for(int i=1;i<=count;i++){
			hight /= 2;  //第一次反弹高度
			if(count <= 9){
				sum += hight*2; //第二次落地	
			}			
		}
		System.out.println("第十次反弹高度为："+hight);
		System.out.println("第十次落地总路程为："+sum);
	}
}
