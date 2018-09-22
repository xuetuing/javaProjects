package day04;

public class Demo11 {
	public static void main(String[] args) {
		//100~999之间的水仙花数(3位自幂数)
		System.out.println("水仙花数为：");
		for(int i=100;i<=999;i++){
			int sum =0;
			int tmp = i;
			int last;
			while(tmp != 0){
				last = tmp%10;
				sum += Math.pow(last,3);
				tmp /= 10;
			}
			if(sum == i){
				System.out.println(i);
			}
		}
			
	}
//	public static boolean findShua(int num){
//		int a,b,c;
//		int tmp = num;
//		a = tmp%10;
//		tmp /= 10;
//		b = tmp%10;
//		tmp /= 10;
//		c = tmp%10;
//		if(a*a*a+b*b*b+c*c*c ==num){
//			return true;
//		}else{
//			return false;
//		}
//		
//		
//	}
}
