package thread;

public class ThreadDemo {
	public static void main(String[] args) {
		//ͬһThread���ഴ�����������󣬻����������������һ������
		Thread1 t1 = new Thread1();
		Thread1 t2 = new Thread1();
		//Thread2 t2 = new Thread2();
//		t1.run();
//		t2.run();
		t1.start();//�̳���Thread����start����
		t2.start();
		//�����߳��������Ǹ�������,�����ݹ���
	}
}

class Thread1 extends Thread{
	private int ticket = 10;
	public void run(){
		for(int i=0;i<10;i++){
			if(this.ticket > 0)
				System.out.println("ticket="+this.ticket--);
		}
	}
}
//class Thread2 extends Thread{
//	public void run(){
//		for(int i=0;i<5;i++){
//			System.out.println("�߳�2");
//		}
//	}
//}


