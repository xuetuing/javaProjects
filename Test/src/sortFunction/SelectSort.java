package sortFunction;

import java.util.Arrays;
//ѡ�����򣺹̶�һ��λ�ã��Դ�λ��Ԫ����������ÿ��Ԫ�ضԱ�
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = {1,56,40,35,4,34,55,60,12};
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
