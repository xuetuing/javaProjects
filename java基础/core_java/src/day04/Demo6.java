package day04;

public class Demo6 {
	//PI=4*(1-1/3+1/5-1/7+1/9.......)
	public static void main(String[] args) {
		double sum = 0;
		double pi;
		for(int i=0;i<1000000;i+=2){
			sum += (1.0/(2*i+1) - 1.0/(2*i+3));
		}
		pi = 4*sum;
		System.out.println(pi);
	}
}
