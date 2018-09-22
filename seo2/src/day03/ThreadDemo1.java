package day03;
//创建线程的第一种方式：继承Thread类
/*
* 弊端：线程与线程要干的事情（任务）耦合在一起
* 
* 使用多线程不应该再考虑执行的先后顺序问题
* 执行没有先后顺序的是异步运行（并发运行）
* 执行有先后顺序的是同步运行
*/
public class ThreadDemo1 {
       public static void main(String[] args) {
			Thread t1 = new Person1();
			Thread t2 = new Person2();
			//注意：启动线程要调用start（）方法，而不是run()方法
			t1.start();
			t2.start();
	}
}
class Person1 extends Thread{
	public void run(){
	for(int i=0;i<1000;i++){	
		System.out.println("你是谁啊？");
	}
	}
}
class Person2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){	
			System.out.println("我是收电费的！");
		}
		}
}