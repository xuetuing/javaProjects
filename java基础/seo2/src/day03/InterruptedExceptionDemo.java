package day03;
//�ж��쳣
public class InterruptedExceptionDemo {
	public static void main(String[] args) {
		/*
		 * �����ߣ�cang teacher
		 * ����˯���������߳�
		 */
		final Thread cang = new Thread(){
			public void run(){
				System.out.println("cang:go to sleep");
				try {
					/*
					 * ��һ���̴߳���˯������ʱ�����������̵߳�����
					 * ��interrupt()�жϣ���sleep()�������׳�
					 * interruptedException�ж��쳣
					 */
					Thread.sleep(1000000);
				} catch (InterruptedException e) {
					System.out.println("cang:what are yo doing?");
				}
			}
		};
		
		/*
		 * �����ߣ�fang
		 * �ж�˯���������߳�
		 */
		Thread fang = new Thread(){
			public void run(){
				System.out.println("fang:I will hit wall.");
				for(int i=0;i<5;i++){
					System.out.println("fang:pa~~~~~");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//�ж�cang��˯������
				cang.interrupt();//���û�д��жϣ�cang�߳̽�������˯��ʱ��
				System.out.println("fang��make it.");
			}
		};
		cang.start();
		fang.start();
	}
}
















