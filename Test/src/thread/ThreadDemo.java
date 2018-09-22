package thread;

public class ThreadDemo {
	public static void main(String[] args) {
		//同一Thread主类创建了两个对象，或者两个主类各创建一个对象
		Thread1 t1 = new Thread1();
		Thread1 t2 = new Thread1();
		//Thread2 t2 = new Thread2();
//		t1.run();
//		t2.run();
		t1.start();//继承自Thread，有start方法
		t2.start();
		//两个线程启动后是各自运行,无数据共享
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
//			System.out.println("线程2");
//		}
//	}
//}


