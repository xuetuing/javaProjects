package test;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {
		int[] a = {1,5,7,9,3,4};
		//ɾ����2����֤���Ȳ��䣬�����λ��0
		int[] index ={5,3};
		for(int i : index){
			delete(i,a);
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	public static int[] delete(int index,int[] a){  //����ɾ���������±���Ҫ�����õ�
		a[index-1] = 0;
		for(int i=index;i<a.length;i++){
			a[i-1] = a[i];
		}
		a[a.length-1] = 0;
		return a;
	}
}
