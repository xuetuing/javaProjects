package day06;

import java.util.Arrays;

public class Demo9 {
	public static void main(String[] args) {
		int[] arr = {1,35,7,8,5,7,354,94,52};
		maoPaoSortDown(arr);
		System.out.println(Arrays.toString(arr));
		maoPaoSortUp(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void maoPaoSortDown(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]<arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}		
	}
	public static void maoPaoSortUp(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}		
	}
	
}
