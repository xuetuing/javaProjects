package testdemo;

public class Transtale {
	public static void main(String[] args) {
		Ay a = new By(); //����ת��
		a.f1();  //ֻҪ��������д���͵������෽��
		//a.f2();  //����ת��ֻ��ʹ�ø����еķ���
		By b = (By)a;//����ת������͸���ĺ������ܷ���
		b.f1();
		b.f2();
		
//		Ay a1 = new Ay();
//		By b1 = (By)a1; //����д���Ǵ����
//		b1.f1();
//		b1.f2();
		
	}
	
}

class Ay{
	public void f1(){
		System.out.println("A�ຯ��");
	}
}

class By extends Ay{
	public void f1(){
		System.out.println("B�ຯ��");
	}
	public void f2(){
		System.out.println("B�ຯ��");
	}
}