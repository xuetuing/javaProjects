package day05;

public class Demo2 {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3};//可以分步写
		int[] arr1 = new int[3];  //0
		String[] arr2 = new String[3];//null
		char[] arr3 = new char[3];  //口
		boolean[] arr4 = new boolean[3];//false
		double[] arr5 = new double[3];//0.0
		float[] arr6 = new float[3];//0.0
		int[] arr7 = {1,2,3};//这种是固定写法，此种形式分步写发生错误
		int[] arr8 = arr7;//arr7和arr8值相同，同一个对象可以被多个引用指向
//		boolean[] used;
//		char[] chs;
//		String[] names;
//		arry = null;
		for(int i=0;i<arr1.length;i++){
			System.out.print(arr7[i]+" ");
		}
	}
}
