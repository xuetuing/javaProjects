package Test;

public class Sushu {
	public static void main(String[] args) {
//		for(int i=101;i<=200;i++){
//			int tmp =(int)Math.sqrt(i);
//			for(int j=2;j<=tmp;j++){
//				if(i%j == 0){
//					break;
//				}
//				if(j==tmp){
//					System.out.println(i);
//				}
//			}
//		}
		for(int i=100;i<=200;i++){
			for(int j=2;j<i;j++){
				if(i%j == 0){
					break;
				}
				if(j==i-1){
					System.out.println(i);
				}
			}
		}
		
	}
}
