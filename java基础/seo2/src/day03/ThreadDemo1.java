package day03;
//�����̵߳ĵ�һ�ַ�ʽ���̳�Thread��
/*
* �׶ˣ��߳����߳�Ҫ�ɵ����飨���������һ��
* 
* ʹ�ö��̲߳�Ӧ���ٿ���ִ�е��Ⱥ�˳������
* ִ��û���Ⱥ�˳������첽���У��������У�
* ִ�����Ⱥ�˳�����ͬ������
*/
public class ThreadDemo1 {
       public static void main(String[] args) {
			Thread t1 = new Person1();
			Thread t2 = new Person2();
			//ע�⣺�����߳�Ҫ����start����������������run()����
			t1.start();
			t2.start();
	}
}
class Person1 extends Thread{
	public void run(){
	for(int i=0;i<1000;i++){	
		System.out.println("����˭����");
	}
	}
}
class Person2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){	
			System.out.println("�����յ�ѵģ�");
		}
		}
}