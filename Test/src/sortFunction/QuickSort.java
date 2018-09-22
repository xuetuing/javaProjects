package sortFunction;

import java.util.Arrays;
/*
 * ���ţ�˼����ѡ����׼Ԫ�أ�һ��ѡ���һ�������һ����ͨ��һ��ɨ��
 * ���������Ϊ�Ȼ�׼Ԫ�ش�ĺͱ���С�������֣���ʱ��׼Ԫ�������ź���
 * ����ȷ��λ�ã�Ȼ������ͬ���ķ����ݹ�����򻮷ֵ������֣�ֱ��������
 * ������Ԫ������Ϊֹ
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










