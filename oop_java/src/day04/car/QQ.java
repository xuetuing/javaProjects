package day04.car;

public class QQ extends CarInfo implements Car,Prodcut{

	@Override
	public void run() {
		System.out.println("run~~~~~");
	}

	@Override
	public void stop() {
		System.out.println("stop~~~~~");
	}

	@Override
	public double getPrice() {
		return 2000;
	}
	
}














