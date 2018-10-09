package day04;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo2 {
	public static void main(String[] args) {
		//ʵ�ֵ���ʱ
		int min = 1;
		long start = System.currentTimeMillis();
		final long end = start + min*60*1000;
		final Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				long show = end - System.currentTimeMillis();
				long h = show/1000/60/60;
				long m = show/1000/60%60;
				long s = show/1000%60;
				System.out.println(h+"ʱ"+m+"��"+s+"��");
			}
		},5000,1000);
		//������ʱ��ʱ��ֹͣȫ���ļƻ�����
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				timer.cancel();
			}
			
		}, new Date(end));
	}
}
