package day01;

public class ExceptionDemo5 {
	public static void main(String[] args) {
		try {
			test(1,0,2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int test(int a,int b,int c) throws Exception{
		/*
		 * �����ǵ��õķ������׳��쳣ʱ�������ǵķ���Ҳ����������쳣ʱ��
		 * ���ǿ��Բ�ȡ�ڵ�ǰ�����ϼ̳�����throws�������쳣�׳�����һ��
		 * ������
		 */
		return divide(a,b)+c;
	}
	/*
	 * ��������
	 * ���������׳���һ���쳣ʱ���÷�����������Ӧ����д
	 * throws�������쳣���׳�
	 */
	public static int divide(int a,int b) throws Exception{ //������������и��쳣
		if(b==0){
			throw new Exception("��������Ϊ0");
		}
		return a/b;
	}
	
	
	
	
}
