package day04;
//�̵߳����ȼ�
public class ThreadPriorityDemo {
	public static void main(String[] args) {
		//������ȼ�
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("max");
				}
			}
		};
		//������ȼ�
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("min");
				}
			}
		};
		//Ĭ�����ȼ�
		Thread norm = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("normal");
				}
			}
		};
		/*
		 * void setPriority(int p)
		 * ���õ�ǰ�̵߳����ȼ�
		 * ��ߡ���͡�Ĭ�϶��г�����Ӧ
		 */
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		//Ĭ�����ȼ����ÿ���ʡ��
		norm.setPriority(Thread.NORM_PRIORITY);
		/*
		 * ���������ȼ�����100%�����̵߳ĵ���
		 * ֻ�����̶ȵĸ����̵߳����Ը���ļ��ʷ���ʱ��Ƭ��
		 * �����ȼ��ߵ��߳�
		 */
		min.start();
		norm.start();
		max.start();
		
	}
}












