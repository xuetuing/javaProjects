package day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo1 {
	public static void main(String[] args) throws ParseException {
		//������ʱ������
		Timer timer = new Timer();
		//��Ӽƻ�����		����"2018-06-27 16:05:00"
		String str = "2018-06-27 16:09:30";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(str);
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				System.out.println("�ó�ҩ��");
			}
		}, date);
		
	}
}






































