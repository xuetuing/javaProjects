package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

//˯������
public class SleepBlockDemo {
	public static void main(String[] args) {
		SleepBlock runnable = new SleepBlock();
		Thread t = new Thread(runnable);
		t.start();
	}
}
//�ڿ���̨ÿһ�����һ�ε�ǰϵͳʱ��
//���ܳ��������������ڽ���ȴ���û�д�ӡ
class SleepBlock implements Runnable{

	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		while(true){
			System.out.println(sdf.format(new Date()));
			try {
				//ÿ���һ�Σ�ֹͣһ��
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}





















