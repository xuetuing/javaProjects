package day04;
/*
 * 使用wait()和notify()方法完成线程的协同工作
 * 这两个方法是Object的方法
 */
public class WaitAndNotifyDemo {
	public static boolean isFinish = false;
	public static Object object = new Object();
	public static void main(String[] args) {
		//下载图片的线程
		Thread download = new Thread(){
			public void run(){
				System.out.println("download:开始下载图片");
				for(int i=0;i<=100;i++){
					System.out.println("download:已完成"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("download:图片下载完毕");
				isFinish = true;//表示图片下载完毕
				synchronized(object){
					object.notify();// 唤醒在此对象监视器上等待的单个线程
				}
				
			}
		};
		//显示图片的线程
		Thread showImg = new Thread(){
			public void run(){
				try {
					synchronized(object){
						System.out.println("准备就绪");
						object.wait();
					}
					
					//download.join(); //等待download线程工作结束
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//等待下载线程工作结束后再执行下面代码
				System.out.println("show:准备显示图片");
				if(!isFinish){
					throw new RuntimeException("图片没有下载完毕");
				}
				System.out.println("show:图片显示了");
			}
		};
		download.start();
		showImg.start();
		
		
		
	}
}
