package day02;

//�������ͱ�������������ʵ����ʱ�򣬲��ܵ����������Ͷ�����������Ժͷ���
//���������������ķ���������ͨ�����룬���Ե���
public class Demo4 {
	public static void main(String[] args) {
		Sub s = new Sub();
		Super ss = new Sub();  //����ת�ͣ�ֻ�ܵ��ø�������Ժͷ���
		System.out.println(s.x);
		s.a();
		//ss.t(); //�������Super����û�ж���t();
		Sub sub = null;
		//sub.t();//�ܱ���ͨ����������ʱ����ֿ�ָ���쳣
		sub = (Sub)s; //һ������������������
		sub.t(); //sub��������t(),���Ա������
		
		
	}
}

class Super{
	int x = 1;
	public void a(){
		System.out.println("super a()");
	}
}

class Sub extends Super{
	int b;
	public void t(){
		System.out.println("sub t()");
	}
}