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
//		System.out.println(a);     //���ַ�������ʽ��ӡ����
//		
//		char[] bye = {'b','y','e'};
//		System.out.println(bye); //�ַ�����Ƚ����⣬����ֱ����Ϊ�ַ������*****
//		System.out.println(bye.toString()); //object�е�toString()�Ǵ�ӡ��ַ��
		System.out.println(arr);
		System.out.println(arr1);
		System.out.println(arr==arr1);//false
		System.out.println(Arrays.equals(arr,arr1));  //ʹ����ʽ
		int[] arr2 = arr1;
		System.out.println(arr1==arr2);// true
 	}
}
