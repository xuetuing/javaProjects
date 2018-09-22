package thread;

public class PrintNm_char {
	public static void main(String[] args) {
		
		PrinterCs p = new PrinterCs();
		Thread t1 = new NumberThread(p);
		Thread t2 = new CharThread(p);
		
		t1.start();
		t2.start();
	}
}

class PrinterCs{
	public int index =1;
	
	public synchronized void printNum(int num){
		while(index%3==0){try{wait();}catch(Exception e){}};
		System.out.print(num);
		index++;
		notifyAll();
	}
	public synchronized void printChar(char ch){
		while(index%3!=0){try{wait();}catch(Exception e){}};
		System.out.print(ch);
		index++;
		notifyAll();
	}
}

class NumberThread extends Thread{
	public PrinterCs p;
	public NumberThread(PrinterCs p) {
		this.p = p;
	}

	public void run(){
		for(int i=1;i<52;i++){
			p.printNum(i);
		}
	}
}

class CharThread extends Thread{
	public PrinterCs p;
	public CharThread(PrinterCs p) {
		this.p = p;
	}
	public void run(){
		for(char i='A';i<'Z';i++){
			p.printChar(i);
		}
	}
}









