package sortFunction;

public class QuickSort3 {
	public void quickSort(int[] arr,int left,int right){
		int temp,middle;
		int i,j;
		if(left>right){
			System.out.println("参数有误");
			return;
		}
		i = left;
		j = right;
		middle = arr[(i+j)/2];
		do{
			while(arr[i]>middle&&i<right)
				i++; //找到左边比中间值小的值
			while(arr[j]<middle&&j>left)
				j--;
			if(i<=j){
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}while(i<=j);
		if(i<right)
			quickSort(arr,left,i);
		if(j>left)
			quickSort(arr,j,right);
	}
	public static void main(String[] args) {
		int[] arr = {12,44,19,20,48,32,1,16};
		QuickSort3 sort = new QuickSort3();
		sort.quickSort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
