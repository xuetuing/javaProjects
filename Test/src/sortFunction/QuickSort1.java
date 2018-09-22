package sortFunction;

public class QuickSort1 {
	
	public void quickSort(String[] strData,int left,int right){
		String middle,tempData;
		if(left>right){
			return;
		}
		int i,j;
		i = left;
		j = right;
		middle = strData[(i+j)/2];
		do{
			while(strData[i].compareTo(middle)<0&&i<right)
				i++;  //�ҳ���߱��м�ֵ�����
			while(strData[j].compareTo(middle)>0&&j>left)
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
		String[] str = new String[]{"11","66","22","20","55","22","32","15"};
		QuickSort1 sort = new QuickSort1();
		
		sort.quickSort(str, 0, str.length-1);
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]+"");
		}
	}
}

























