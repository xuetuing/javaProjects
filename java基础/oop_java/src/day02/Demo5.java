package day02;

//���๹����Ĭ�ϵ��ø��๹����
public class Demo5 {
	public static void main(String[] args) {
		new Hoo();
	}
}

class Joo{
	public Joo(int a){
		System.out.println("Joo(int a)");
	}
}

class Hoo extends Joo{ //������󣬸���û���޲ι�����
	public Hoo(){
		///super();//���󣬵��ø�����޲ι�����
		super(5);//��ȷ�����������вΣ�ֻ�ܷ��ڵ�һ��
		System.out.println("Hoo()");
	}
	
}