package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

//睡眠阻塞
public class SleepBlockDemo {
	public static void main(String[] args) {
		SleepBlock runnable = new SleepBlock();
		Thread t = new Thread(runnable);
		t.start();
	}
}
//在空中台每一秒输出一次当前系统时间
//可能出现跳秒现象，由于进入等待而没有打印
class SleepBlock implements Runnable{

	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		while(true){
			System.out.println(sdf.format(new Date()));
			try {
				//每输出一次，停止一秒
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}





















