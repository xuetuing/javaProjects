package day05;

public class Demo6 {
	/*
	 * 1 1 2 3 5.......
	 * 1 2 3 4 5
	 * 根据位置找对应的数值
	 */
	public static void main(String[] args) {
		 long num = findNum(7);
		 System.out.println(num);
	}
//	public static long findNum(int index){
//		long n1 = 1;
//		long n2 = 1;
//		if(index==1 || index==2){
//			return 1;
//		}else{
//			for(int i=1;i<=index-2;i++){
//				int tmp = n1 + n2;
//				n1 = n2;
//				n2 = tmp;
//			}
//			return n2;
//		}
//	}
//		long n1 = 1,n2 = 1,tmp = 1;
//		
//		for(int i=3;i<=index;i++){
//			int tmp = n1 + n2;
//			n1 = n2;
//			n2 = tmp;
//			}
//			return tmp;
	
	
	public static long findNum(int index){
		if(index==1 || index==2){
			return 1;
		}else{
			return findNum(index-1)+findNum(index-2);
		}
	}
}
       