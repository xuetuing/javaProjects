package day01;
/*
 * ģ��ģʽ�����Ʒ���
 * ��ͬ���������������ú�ģ�壬���巽�������ó����ൽ����ʵ��
 */
public abstract class Template {
	public void sayHello(){
		System.out.println("��Һã�");
		sayName();
		sayInfo();
		System.out.println("лл���ټ�");
	}
	
	public abstract void sayName();
	public abstract void sayInfo();
	
	
}
