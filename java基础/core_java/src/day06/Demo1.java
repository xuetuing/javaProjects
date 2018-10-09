package day06;

import java.util.Arrays;

//Arrays.toString()
//Arrays.equals()
public class Demo1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int[] arr1 = {1,2,3};
//		System.out.println(arr);
//		String a = Arrays.toString(arr);
//		System.out.println(a);     //以字符串的形式打印出来
//		
//		char[] bye = {'b','y','e'};
//		System.out.println(bye); //字符数组比较特殊，可以直接作为字符串输出*****
//		System.out.println(bye.toString()); //object中的toString()是打印地址的
		System.out.println(arr);
		System.out.println(arr1);
		System.out.println(arr==arr1);//false
		System.out.println(Arrays.equals(arr,arr1));  //使用形式
		int[] arr2 = arr1;
		System.out.println(arr1==arr2);// true
 	}
}
