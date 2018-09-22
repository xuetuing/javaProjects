package test;

public class OuterDemo {

}

interface Inner{
	void show();
}
class Outer{
	public static Inner method(){
		return new Inner(){
			@Override
			public void show() {
				System.out.println("hello world!");
				
			}
		};
	}
}