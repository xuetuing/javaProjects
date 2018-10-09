package day04;

public class SyncDemo {
	public static void main(String[] args) {
		Table table = new Table();
		Thread t1 = new Person(table);
		Thread t2 = new Person(table);
		t1.start();
		t2.start();
		
	}
}

class Table{
	int beans = 20;
//	public synchronized int getBeans(){
//		
//		if(beans==0){
//			throw new RuntimeException("���ӱ�ȡ����");
//		}
//		//�����ó�CPU,���߳��ó�CPU���뿪running״̬��,ʹ������runnable�ȴ�״̬
//		Thread.yield();
//		return beans--;
//	}
	public int getBeans(){
		synchronized(this){
			if(beans==0){
				throw new RuntimeException("���ӱ�ȡ����");
			}
		}
		Thread.yield();
		return beans--;
	}
}
class Person extends Thread{
	private Table table;
	public Person(Table table){
		this.table = table;
	}
	public void run(){
		while(true){
			int bean = table.getBeans();
			/*
			 * String getName()
			 * ��ȡ�߳��������̵߳��Ⱥ󱻷��������
			 */
			System.out.println(getName()+"."+bean);
		}
	}
}






















