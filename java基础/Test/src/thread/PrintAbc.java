package thread;
//实例化3个线程，分别打印:a,b,c,三个线程同时执行，
//要求打印出6个连续的abc

public class PrintAbc {
	public static void main(String[] args) {
		
//		Thread t1 = new Thread(new Task_1('a'));
//		Thread t2 = new Thread(new Task_1('b'));
//		Thread t3 = new Thread(new Task_1('c'));
		
//		t1.start();
//		t2.start();
//		t3.start();
		Object o = new Object();
		Task_1 t1 = new Task_1('a',o);
		Task_1 t2 = new Task_1('b',o);
		Task_1 t3 = new Task_1('c',o);
		
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
	}
}

class Task_1 implements Runnable{
	private char ch;
	private int index = 0;
	final int id = index++;
	public Object obj;
	public Task_1(char ch,Object obj){
		this.ch = ch;
		this.obj = obj;
	}
	@Override
	public void run() {
		int count = 0;
		//Object obj = new Object();
		
		synchronized(obj){
			while(true){
				if(count>6)
					break;
				System.out.println("任务"+index+":"+ch);
				count++;
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				notifyAll();
			}
			
		}
		
	}
	
}





























