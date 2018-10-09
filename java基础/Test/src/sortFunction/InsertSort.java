package sortFunction;

public class InsertSort {
	public void insertSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int key = arr[i];
			int position = i;
			while(i>0 && arr[position-1]>key){
				arr[position] = arr[position-1];
				position--;
			}
			arr[position] = key;
		}
		
	}
}
