package day03;

public class IntegerDemo1 {
	public static void main(String[] args) {
		/*
		 * ��װ������ͨ�����췽������������ת��Ϊ��Ӧ�İ�װ��ʵ��
		 */
		Integer i = new Integer(1);
		Long l = new Long(1);
		Double d = new Double(1.0);
		
		Integer i1 = new Integer(1);
		System.out.println(i == i1);
		System.out.println(i.equals(i1));//��װ����д��equals()����
		
		/*
		 * ������װ��ʵ��ʱ�Ƽ�ʹ�ð�װ���ṩ�ľ�̬����
		 * valueOf()
		 */
		Integer n1 = Integer.valueOf(127);
		Integer n2 = Integer.valueOf(127);
		/*
		 * Integer��valueOf()�����ĺô����ڻὫ������
		 * ��ֵ���棬�����ã��仺��ķ�Χ��һ���ֽڣ�byte����ֵ
		 */
		System.out.println(n1 == n2);//true �Ỻ��
		
		Double d1 = Double.valueOf(1.0);
		Double d2 = Double.valueOf(1.0);
		System.out.println(d1 == d2);//false  �޻���
		
		Long l1 = Long.valueOf(1);
		Long l2 = Long.valueOf(1);
		System.out.println(l1 == l2);//true  �Ỻ��
		
		/*
		 * �Ӱ�װ��ת��Ϊ��������
		 * ��װ�඼֧��һ��������xxxValue()
		 */
		int in = i.intValue();
		double db = d1.doubleValue();
		System.out.println(in+","+db);
	}
}




























