package day04;

public class SyncDemo {
	public static void main(String[] args) {
		Table table = new Table();
		Thread t1 = new Person(table);
		Thread t2 = new Person(table);
		t1.start();
		t2.start();
		
	}
}

class Table{
	int beans = 20;
//	public synchronized int getBeans(){
//		
//		if(beans==0){
//			throw new RuntimeException("豆子被取完了");
//		}
//		//主动让出CPU,当线程让出CPU（离开running状态）,使它进入runnable等待状态
//		Thread.yield();
//		return beans--;
//	}
	public int getBeans(){
		synchronized(this){
			if(beans==0){
				throw new RuntimeException("豆子被取完了");
			}
		}
		Thread.yield();
		return beans--;
	}
}
class Person extends Thread{
	private Table table;
	public Person(Table table){
		this.table = table;
	}
	public void run(){
		while(true){
			int bean = table.getBeans();
			/*
			 * String getName()
			 * 获取线程在纳入线程调度后被分配的名字
			 */
			System.out.println(getName()+"."+bean);
		}
	}
}






















