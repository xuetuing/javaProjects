package day02;

import org.apache.commons.lang3.StringUtils;

/*
 * commons-lang  �ð�����Apache��֯�ṩ��������չjava��
 * lang�������һЩ����
 */
public class Demo5 {
	public static void main(String[] args) {
		/*
		 * String repeat(String str,int repeat)
		 * ���������ַ����ظ������ķ���
		 */
		String repeat = StringUtils.repeat("abc",5);
		System.out.println(repeat);
		
		String str = "123,456,789";
		String[] array = str.split(",");
		
		/*
		 * join()
		 * �������������е�ÿһ��ո������ַ���������һ��
		 * �������������split()�ķ�����
		 */
		String join = StringUtils.join(array,".");
		System.out.println(join);
		
		/*
		 * String leftPad(String str,int size,char chs)
		 * ���������ַ���str���������ɸ��������ַ�chs,��ʹ��ǰ�ַ���
		 * �ﵽ�����ĳ���size
		 */
		String str1 = "1234";
		String leftPad = StringUtils.leftPad(str1,10,'*');
		System.out.println(leftPad);
		/*
		 * String rightPad()
		 * ��leftPad()��ͬ��ֻ�����Ҳಹ���ַ�
		 */
		String rightPad = StringUtils.rightPad(str1,10,'#');
		System.out.println(rightPad);
	}
	
}






















