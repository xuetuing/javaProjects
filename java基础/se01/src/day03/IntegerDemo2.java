package day03;

public class IntegerDemo2 {
	public static void main(String[] args) {
		Object[] arr = new Object[10];
		//��������Ҫ������������Ϊ�������Ϳ���ʱ:
		arr[0] = Integer.valueOf(1);
		/*
		 * ������﷨��JDK1.5֮ǰ�ǷǷ��ģ���1.5֮������
		 * ���Եģ�1.5֮���Ƴ��������ԣ��Զ���װ��
		 */
		arr[0] = 1;//�Զ�����������ת��Ϊ��װ�ࣺ�Զ�װ��
		Integer i = (Integer)arr[0];
		//�����Ҫ����װ�ౣ��Ļ����������ݻ�ȡ��ʱ��
		int in = i.intValue();
		/*
		 * ��������Ҫ����װ��ת���ɻ�����������ʱ�����Զ��������
		 * Ӧ��xxxValue()�������Զ�����
		 */
		in = i;  //�Զ�����
		
	}
}





























