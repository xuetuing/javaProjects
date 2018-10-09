package testdemo;

public class SuperTest {
	public static void main(String[] args) {
		BB b = new BB();
		b.print();
	}
}

class AA{
	public void print(){
		System.out.println("A¿‡");
	}
	
}

class BB extends AA{
	public void print(){
		super.print();
		System.out.println("B¿‡");
	}
}






