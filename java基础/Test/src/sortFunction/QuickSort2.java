package sortFunction;

public class QuickSort2 {
	public void quickSort(int[] strData,int left,int right){
		int middle,tempData;
		if(left>right){
			System.out.println("参数有误");
			return;
		}
		int i,j;
		i = left;
		j = right;
		middle = strData[(i+j)/2];
		do{
			while(strData[i]<middle&&i<right)
				i++;  //找出左边比中间值大的数
			while(strData[j]>middle&&j>left)
				j--; //找出右边比中间值小的数
			if(i<=j){ //将左边大的数和右边小的数进行交换
				tempData = strData[i];
				strData[i] = strData[j];
				strData[j] = tempData;
				i++;
				j--;
			}
		}while(i<=j); //当两者交错时停止
		if(i<right){
			quickSort(strData,i,right);
		}
		if(j>left){
			quickSort(strData,left,j);
		}
	}
	
	public static void main(String[] args) {
		int[] str = {11,66,22,20,55,22,32,15,0};
		QuickSort2 sort = new QuickSort2();
		
		sort.quickSort(str,str.length-1,0);
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
	}
}
