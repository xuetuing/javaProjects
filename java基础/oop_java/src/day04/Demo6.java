package day04;

public class Demo6 {
	public static void main(String[] args) {
		int c = add(2,3);
		Xoo x1 = new Xoo();
		Xoo x2 = new Xoo();
		System.out.println(x1.id+","+x2.id+","+Xoo.i);//0,1,2
		
		Poo p = new Poo();
		//p.a = 9;
		
		final Poo p1 = new Poo();  //final–ﬁ Œµƒ «p1 
		//p1 = null;
	}
	public static int add(final int a,int b){  //
		b++;
		return a+b;
	}
}
class Poo{
	final int a = 1;
}
class Xoo{
	final int id;
	static int i = 0;
	public Xoo(){
		id = i++;
	}
}