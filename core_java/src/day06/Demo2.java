package day06;

import java.util.Arrays;

public class Demo2 {
	public static void main(String[] args) {
		int[] arr = {15,56,84,36,81,89,21,53,20};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);  //用法，无返回值
		System.out.println(Arrays.toString(arr));
		int a = Arrays.binarySearch(arr,16);  //-2
		System.out.println(a);
//		System.out.println(Arrays.toString(arr));
//		String[] names = {"Tom","Jack","Mike","Summer","Smith",};
//		Arrays.sort(names); //unicode 编号
//		System.out.println(Arrays.toString(names));
	}
}
