package day04;

public abstract class Demo7 {
	public int add(int a,int b){
		return a+b;
	}
	public abstract int add();
	public static void main(String[] args){
		Demo7 demo;//只能定义引用变量
		//Demo7 demo = new Demo7();
	}
}
