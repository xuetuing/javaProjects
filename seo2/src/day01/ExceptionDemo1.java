package day01;
//java�쳣������ƣ�������ֻ�ܽ��Exception�����ܽ��Error
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		/*
		 * JVM����Ҫ����һ��null�ķ�����JVM����һ����ָ��
		 * �쳣��ʵ�����������﷢�����쳣���ڵ�ǰ���׳��쳣��
		 * �׳���JVM�������Ƭ�Σ��鿴�Ƿ����쳣�������
		 * �����ֵ�ǰ������û���쳣������ƣ��򽫸��쳣ʵ���׳���
		 * ��ǰ�������ڵķ���֮�⣬���쳣���׳���main����֮��ʱ��
		 * JVM��ɱ����ǰ���򣬳����˳�
		 */
		try {
			//String str = null;
			//String str = "";
			String str = "a";
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			int i = Integer.parseInt(str);
			System.out.println(i);
			/*
			 * ������Ĵ���Ƭ�γ������쳣��������try���飬
			 * try������ʣ�µĴ���Ƭ�β��ܱ�ִ��
			 */
			System.out.println("���ݶ�ִ����");
		} catch (NullPointerException e) {
			System.out.println("�����˿�ָ���쳣");
		} catch (StringIndexOutOfBoundsException e){
			System.out.println("�������ַ����±�Խ���쳣");
		} catch (Exception e){
			/*
			 * �쳣������Ƶ�����ϰ�ߣ�
			 * �����һ��catch����Exception���Ա�֤�ɲ������
			 * �г��ֵ������쳣��ʹ���򲻻������������
			 * 
			 */
			System.out.println("���˸�����");
		}
		
		System.out.println("���������");
		
		
	}
}
