package day03;

import java.util.Calendar;
import java.util.Date;
//Calendar���Date���ת��
public class Demo1 {
	public static void main(String[] args) {
		//Calendar calendar = new Calendar();
		//ͨ������������ȡʵ��
		Calendar calendar = Calendar.getInstance();
		//ͨ������ʹ�õ��Ǹ����������
		//Calendar calendar1 = new GregorianCalendar();
		//Ĭ������´�����calendar������ʾ���ǵ�ǰϵͳʱ��
		System.out.println(calendar);
		/*
		 * �鿴Calendar ��ʱ�䣬ͨ������ö���õ����ַ������Ѻ�
		 * �����Ƚ�Calendarת��ΪDate����
		 * Date getTime()
		 * �÷����������ǽ���ǰcalendar������ʱ��ת��Ϊһ��Date���󲢷���
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		/*
		 * void  setTime()
		 * ʹ��ǰCalendar����������Date������������ʱ��
		 */
		Date now = new Date();
		calendar.setTime(now);
		System.out.println(calendar);
		
		
	}
}
