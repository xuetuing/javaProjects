package sortFunction;

import java.util.Arrays;
//冒泡排序：每轮前后两个相邻元素对比
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {1,5,9,6,4,20};
		arr = bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
		
	}
	public static int[] bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		return arr;
	}
	
}
