package day01;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo6 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "�Ұ�python";
		byte[] gbk = str.getBytes("GBK");//Ӣ��ռһ���ֽ�
		System.out.println(gbk.length);
		System.out.println(Arrays.toString(gbk));
		
		byte[] utf = str.getBytes("utf-8");
		System.out.println(utf.length);
		System.out.println(Arrays.toString(utf));
		
		/*
		 * String(byte[] dta,String charserName)
		 * �������
		 */
		String utfStr = new String(utf,"UTF-8");
		System.out.println(utfStr);
		
		
		//���ַ���ת��Ϊ�ֽ����У��ֽ��룩�Ĺ��̳�Ϊ����
		//���ֽ����У��ֽ��룩ת��Ϊ�ַ����Ĺ��̳�Ϊ����
	}
}




















