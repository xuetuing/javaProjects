package testdemo;

public class Graph {
	public static void main(String[] args) {
		//sanjiao();
		linxing();
	}
	public static void sanjiao(){
		for(int i=1;i<=5;i++){
			for(int j=5-i;j>=0;j--){
				System.out.print(" ");
			}
			for(int k=1;k<=2*i-1;k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void linxing(){
		for(int i=1;i<=5;i++){
			for(int j=1;j<=5-i;j++){
				System.out.print(" ");
			}
			for(int k=1;k<=2*i-1;k++){
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1;i<5;i++){
			for(int j=1;j<=i;j++){
				System.out.print(" ");
			}
			for(int k=7;k>=2*i-1;k--){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
