package day07;

public class Demo1 {
	public static void main(String[] args) {
		//int sum = sum(20);
		int s = f(9100); 
		//System.out.println(sum);
		System.out.println(s);
	}
	public static int sum(int n){
		int sum = 0;
		for(int i=1;i<=n;i++){
			sum += i;
		}
		return sum;
	}
	public static int f(int n){
		if(n == 1){
			return 1;
		}
		return f(n-1)+n;  //有一个是功能项，需要有个结束条件
	}
}
