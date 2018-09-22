package sortFunction;

public class QuickSort2 {
	public void quickSort(int[] strData,int left,int right){
		int middle,tempData;
		if(left>right){
			System.out.println("��������");
			return;
		}
		int i,j;
		i = left;
		j = right;
		middle = strData[(i+j)/2];
		do{
			while(strData[i]<middle&&i<right)
				i++;  //�ҳ���߱��м�ֵ�����
			while(strData[j]>middle&&j>left)
				j--; //�ҳ��ұ߱��м�ֵС����
			if(i<=j){ //����ߴ�������ұ�С�������н���
				tempData = strData[i];
				strData[i] = strData[j];
				strData[j] = tempData;
				i++;
				j--;
			}
		}while(i<=j); //�����߽���ʱֹͣ
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
