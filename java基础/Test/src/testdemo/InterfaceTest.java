package testdemo;

public class InterfaceTest {
	public static void main(String[] args) {
		System.out.println("����ͨ��");
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
class D implements C{   //�����Dǰ������Ȩ����public,����Ҫ����д�뵥���ļ�

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