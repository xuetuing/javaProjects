package day02;

import java.util.Date;
/*
 * ������ϴ����������⣺
 * 1.ǧ�������
 * 2.ʱ������
 */
public class DateDemo {
	public static void main(String[] args) {
		/*
		 * Date()
		 * �ù��췽�����������Ķ���Ĭ�ϱ�ʾ��ǰϵͳʱ��
		 * 
		 */
		Date now = new Date();
		//System.out.println(now);
		/*
		 * long getTime()
		 * ��ȡDate������ʱ�����1970��Ԫ���ĺ����
		 */
		long ms = now.getTime();
		System.out.println(ms);
		
		//���㣬������һ�̵ĺ���
//		ms += 24*60*60*1000;
//		System.out.println(ms);
		//����һ��Date����,���������ĺ���ֵ����ʾ��ʱ��
		Date td = new Date(ms);
		System.out.println(td);
		/*
		 * setTime()
		 * ʹ��ǰ�����ʾ �����ĺ���ֵ��������ʱ��
		 */
		now.setTime(ms);
		System.out.println(now);
		
	}
}



















































