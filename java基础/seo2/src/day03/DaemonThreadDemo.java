package day03;
//后台线程
public class DaemonThreadDemo {
	public static void main(String[] args) {
		//cang:前台线程
		Thread cang = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("cang：let me jump!");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("cang:!!!!!");
				System.out.println("piipopi");
			}
		};
		//fang:后台线程
		Thread fang = new Thread(){
			public void run(){
				while(true){
					System.out.println("fang:you jump,I jump!");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//设置后台线程(要在该线程调用start()之前调用)
		fang.setDaemon(true);
		cang.start();
		fang.start();
		
	}
}















