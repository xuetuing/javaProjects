package day06;

import java.util.Arrays;
//ѡ�����򣺹̶�һ��λ�ã��ô�λ�õ�Ԫ�طֱ������ÿһ��Ԫ�ضԱ�
public class Demo10 {
	public static void main(String[] args) {
		int[] arr = {1,35,7,8,5,7,354,94,52}; 
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]<arr[j]){     //arr[i]>arr[j]
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
