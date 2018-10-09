package day04;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//线程池
public class ThreadPoolDemo {
	public static void main(String[] args) {
		Process p1 = new Process();
		Process p2 = new Process();
		Process p3 = new Process();
		Process p4 = new Process();
		Process p5= new Process();
		
		Executor threadPool = Executors.newFixedThreadPool(2);
		threadPool.execute(p1);//将任务提交给线程池处理
		threadPool.execute(p2);
		threadPool.execute(p3);
		threadPool.execute(p4);
		threadPool.execute(p5);
	}
}
class Process implements Runnable{
	static int index = 1;
	int id;
	public Process(){
		id = index++;
	}
	@Override
	public void run() {
		System.out.println(id+"开始了~~~");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(id+"结束了~~~");
	}
	
}