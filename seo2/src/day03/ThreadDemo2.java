package day03;
//�����̵߳ĵڶ��ַ�ʽ��ʵ��Runnable�ӿڣ�����ӿڣ�
//���������߳̽���������̷߳��룩
public class ThreadDemo2 {
	public static void main(String[] args) {
		Runnable r1 = new Runnable1();
		Runnable r2 = new Runnable2();
		//�����߳�ʱ�ٽ�����ָ��
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
//������������
class Runnable1 implements Runnable{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("����˭��");
		}
	}
}

class Runnable2 implements Runnable{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println();
		}
	}
}




























