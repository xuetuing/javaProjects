package day04;
//�̵߳�Эͬ����
public class JoinThreadDemo {
	//��ʾͼƬ�Ƿ��������
	public static boolean isFinish = false;
	public static void main(String[] args) {
		//����ͼƬ���߳�
		final Thread download = new Thread(){
			public void run(){
				System.out.println("download:��ʼ����ͼƬ");
				for(int i=0;i<=100;i++){
					System.out.println("download:�����"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("download:ͼƬ�������");
				isFinish = true;//��ʾͼƬ�������
			}
		};
		//��ʾͼƬ���߳�
		Thread showImg = new Thread(){
			public void run(){
				try {
					download.join(); //�ȴ�download�̹߳�������
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//�ȴ������̹߳�����������ִ���������
				System.out.println("show:׼����ʾͼƬ");
				if(!isFinish){
					throw new RuntimeException("ͼƬû���������");
				}
				System.out.println("show:ͼƬ��ʾ��");
			}
		};
		download.start();
		showImg.start();
	}
}























