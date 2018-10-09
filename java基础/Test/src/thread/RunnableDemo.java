package thread;

public class RunnableDemo {
	public static void main(String[] args) {
		Task task = new Task();
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class Task implements Runnable{
	private int ticket = 10;
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			if(this.ticket > 0)
			System.out.println("ticket="+this.ticket--);
		}
	}
}




















