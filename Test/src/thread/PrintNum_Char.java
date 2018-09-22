package thread;

public class PrintNum_Char {
	public static void main(String[] args) {
		Printer p = new Printer();
		Thread t1 = new NumberPrinter(p);
		Thread t2 = new LetterPrinter(p);
		t1.start();
		t2.start();
	}
}

class Printer{
	private int index = 1;//��Ϊ1���������3�ı���
	//��ӡ���ֵĹ��췽����ÿ��ӡ�������֣��ȴ���ӡһ����ĸ
	public synchronized void print(int i){
		while(index%3==0){try{wait();}catch(Exception e){}}
		System.out.print(i);
		index++;
		notifyAll();
	}
	//��ӡ��ĸ��ÿ��ӡһ����ĸ���ȴ���ӡ��������
	public synchronized void print(char c){
		while(index%3!=0){try{wait();}catch(Exception e){}}
		System.out.print(c);
		index++;
		notifyAll();
	}
}
	//��ӡ���ֵ��߳�
class NumberPrinter extends Thread{
	private Printer p;
	public NumberPrinter(Printer p){this.p = p;}
	public void run(){
		for(int i = 1; i<=52; i++){
		p.print(i);
		}
	}
}
	//��ӡ��ĸ���߳�
class LetterPrinter extends Thread{
	private Printer p;
	public LetterPrinter(Printer p){this.p = p;}
	public void run(){
		for(char c='A'; c<='Z'; c++){
			p.print(c);
		}
	}
}


