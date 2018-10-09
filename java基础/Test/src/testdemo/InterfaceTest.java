package testdemo;

public class InterfaceTest {
	public static void main(String[] args) {
		System.out.println("编译通过");
	}
}

interface A{
	void print0();
}
interface B{
	void print1();
}
interface C extends A,B{
	void print();
}
abstract class E implements A,B{
	
}
class D implements C{   //如果类D前带访问权限如public,则需要将其写入单独文件

	public void print() {
		System.out.println();
	}

	public void print0() {
		System.out.println();
	}

	public void print1() {
		System.out.println();
	}

}