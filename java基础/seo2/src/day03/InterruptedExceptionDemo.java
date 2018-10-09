package day03;
//中断异常
public class InterruptedExceptionDemo {
	public static void main(String[] args) {
		/*
		 * 表演者：cang teacher
		 * 处于睡眠阻塞的线程
		 */
		final Thread cang = new Thread(){
			public void run(){
				System.out.println("cang:go to sleep");
				try {
					/*
					 * 当一个线程处于睡眠阻塞时，若被其他线程调用了
					 * 其interrupt()中断，则sleep()方法会抛出
					 * interruptedException中断异常
					 */
					Thread.sleep(1000000);
				} catch (InterruptedException e) {
					System.out.println("cang:what are yo doing?");
				}
			}
		};
		
		/*
		 * 表演者：fang
		 * 中断睡眠阻塞的线程
		 */
		Thread fang = new Thread(){
			public void run(){
				System.out.println("fang:I will hit wall.");
				for(int i=0;i<5;i++){
					System.out.println("fang:pa~~~~~");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//中断cang的睡眠阻塞
				cang.interrupt();//如果没有此中断，cang线程将进行完睡眠时间
				System.out.println("fang：make it.");
			}
		};
		cang.start();
		fang.start();
	}
}
















