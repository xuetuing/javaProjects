package thread;

public class PrintNm_ChRunnable {
	public static void main(String[] args) {
		Printer_Cn p = new Printer_Cn();
		Thread t1 = new Thread(new task_Nm(p));
		Thread t2 = new Thread(new task_Ch(p));
		
		t1.start();
		t2.start();
	}
}

class Printer_Cn{
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

class task_Nm implements Runnable{
	Printer_Cn p;
	
	public task_Nm(Printer_Cn p) {
		this.p = p;
	}

	@Override
	public void run() {
		for(int i=1;i<=52;i++){
			p.print_Nm(i);
		}
	}
	
}

class task_Ch implements Runnable{
	Printer_Cn p;
	
	
	public task_Ch(Printer_Cn p) {
		this.p = p;
	}

	@Override
	public void run() {
		for(char i='A';i<='Z';i++){
			p.print_Ch(i);
		}
	}
	
}









