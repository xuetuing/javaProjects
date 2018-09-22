package day04;

public class Demo4 {
	public static void main(String[] args) {
		Koo k1 = new Koo(); 
		Koo k2 = new Koo();
		Koo k3 = new Koo();
		System.out.println(k1.id+","+k2.id+","+k3.id+","+Koo.i);//0,1,2,3
	}
}

class Koo{
	int id;
	static int i = 0;
	public Koo(){
		id = i++;
	}
}