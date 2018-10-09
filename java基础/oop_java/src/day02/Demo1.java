package day02;

public class Demo1 {
	public static void main(String[] args) {
		Foo foo = new Foo();
		//Goo goo = new Goo(); 
		Goo goo = new Goo(5);
		System.out.println(goo);
	}
}

class Foo{
	
}
class Goo{
	public Goo(int i){
		System.out.println("Goo(i)");
	}
}