package sortFunction;

import java.util.Arrays;
/*
 * 快排：思想是选定基准元素，一般选择第一个或最后一个，通过一趟扫描
 * 将待排序分为比基准元素大的和比其小的两部分，此时基准元素在其排好序
 * 后正确的位置，然后再用同样的方法递归地排序划分的两部分，直到序列中
 * 的所有元素有序为止
 */

public class QuickSort {
	public static void sort(int[] a,int low,int hight){
		int i,j,index;
		if(low>hight){
			return;
		}
		i = low;
		j = hight;
		index = a[i];
		while(i<j){
			while(i<j && a[j]>=index){j--;}
			if(j>i){
				a[i] = a[j];
				i += 1;
			}
			while(i<j && a[i]<index){
				i += 1;
			}
			if(j>i){
				a[j] = a[i];
				j--;
			}
		}
		a[i] = index;
		sort(a,low,i-1);
		sort(a,i+1,hight);
	}
	public static void main(String[] args) {
		int[] a = {2,16,48,10,25,62,41};
		sort(a,0,6);
		System.out.println(Arrays.toString(a));
	}
}










