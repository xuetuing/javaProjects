package day06;

import java.util.Arrays;

//ð������ѡ������
public class Demo11 {
	public static void main(String[] args) {
		int[] arr = {25,65,20,10,89,62,42,3,4,8};
		maoPaoSort(arr);
		System.out.println(Arrays.toString(arr));
		chooseSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void maoPaoSort(int[] arr){  //���������ǽ���ÿһ�ֲ�������Сֵ�����ֵ���ᱻ������˳�������һ��
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){     //arr[j]<arr[j+1]
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	public static void chooseSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]<arr[j]){   //arr[i]>arr[j]
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
}
