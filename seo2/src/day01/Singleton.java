package day01;
//����ģʽ
public class Singleton {
	//˽�л�������
	private Singleton() {}
//	static Singleton instance = new Singleton();
	//����һ��˽�еľ�̬�ĵ�ǰ����ʵ��
	private static Singleton instance = new Singleton();
	//�������еľ�̬���ܹ����ص�ǰ����ʵ���ķ���
	public static Singleton getInstance(){
		return instance;
	}
}
