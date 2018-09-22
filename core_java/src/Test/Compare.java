package Test;

import java.util.Scanner;

public class Compare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input the first num:");
		int x = sc.nextInt();
		System.out.print("input the second num:");
		int y = sc.nextInt();
		System.out.print("input the third num:");
		int z = sc.nextInt();
//		for(int i=0;i<=3;i++){    //次数为n*(n-1)/2
//			if(x>y){
//				int tmp = x;
//				x = y;
//				y = tmp;
//			}else if(x>z){
//				int tmp = x;
//				x = z;
//				z = tmp;
//			}
//			if(y>z){
//				int tmp = y;
//				y = z;
//				z = tmp;
//			}
//		}
		if(x>y){
			int tmp = x;
			x = y;
			y = tmp;
		} 
		if(x>z){
			int tmp = x;
			x = z;
			z = tmp;
		}
		if(y>z){
			int tmp = y;
			y = z;
			z = tmp;
		}
		System.out.println("排序后为："+x+","+y+","+z);
	}
}
