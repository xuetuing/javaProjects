package day03;
//��̨�߳�
public class DaemonThreadDemo {
	public static void main(String[] args) {
		//cang:ǰ̨�߳�
		Thread cang = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("cang��let me jump!");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("cang:!!!!!");
				System.out.println("piipopi");
			}
		};
		//fang:��̨�߳�
		Thread fang = new Thread(){
			public void run(){
				while(true){
					System.out.println("fang:you jump,I jump!");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//���ú�̨�߳�(Ҫ�ڸ��̵߳���start()֮ǰ����)
		fang.setDaemon(true);
		cang.start();
		fang.start();
		
	}
}















