package day06;

import java.util.Arrays;

//Arrays.copyOf()
public class Demo3 {
	public static void main(String[] args) {
		int[] arr = {2,3,4};
		int[] arr1 = arr;
		System.out.println(arr == arr1);//true
		
		arr1 = Arrays.copyOf(arr, arr.length);
		System.out.println(Arrays.toString(arr1));
		System.out.println(arr == arr1); //false
		String[] list = {"极限挑战","奔跑","快乐"};
		System.out.println(Arrays.toString(list));
		System.out.println(list.length);
		list = Arrays.copyOf(list,list.length+1);
		list[list.length-1] = "向往";
		System.out.println(Arrays.toString(list));
		System.out.println(list.length);
		
	}
}
