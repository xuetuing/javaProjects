package day07;

public class Demo2 {
	public static void main(String[] args) {
		
	}
	public static long f1(int index){
		long n1 = 1;
		long n2 = 1;
		
		if(index==1 || index==2){
			return 1;
		}else{
			for(int i=0;i<index-1;i++){
				long tmp = n1+n2;
				n1 = n2;
				n2 = tmp;
			}
			return n2;
		}
				
	}
			
	public static long f2(int index){
		if(index==1 || index==2){
			return 1;
		}
		return f2(index-1)+f2(index-2);
		
			
	}
}
