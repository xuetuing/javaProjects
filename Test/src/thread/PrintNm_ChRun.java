package thread;

public class PrintNm_ChRun {

	public static void main(String[] args) {
		Printer_Cb p = new Printer_Cb();
		Thread t1 = new Thread(new task_NC(p,'N'));
		Thread t2 = new Thread(new task_NC(p,'C'));
		
		t1.start();
		t2.start();
	}


}

class Printer_Cb{
	public int index = 1;
	
	public synchronized void print_Nm(int num){
		while(index%3==0){try{wait();}catch(Exception e){}}
		System.out.print(num);
		index++;
		notifyAll();
		
	}
	public synchronized void print_Ch(char ch){
		while(index%3!=0){try{wait();}catch(Exception e){}}
		System.out.print(ch);
		index++;
		notifyAll();
	}
}

class task_NC implements Runnable{
	Printer_Cb p;
	final char ch;


	public task_NC(Printer_Cb p, char ch) {
		this.p = p;
		this.ch = ch;
	}
	
	@Override
	public void run() {
		switch(ch){
		case 'C':
			for(int i=1;i<=52;i++){
				p.print_Nm(i);
			}
			break;
		case 'N':
			for(char i='A';i<='Z';i++){
				p.print_Ch(i);
			}
		}
		
	}
	
}

