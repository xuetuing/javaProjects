package day01;

public class Demo1 {
	public static void main(String[] args) {
//		Aoo aoo = new Aoo(10);
//		System.out.println(aoo.toString());
//		String s = "abc";
//		String s3 = "abc";
//		System.out.println(s==s3);//true，类似常量的形式
//		System.out.println(s);
//		String s1 = new String("abc");
//		System.out.println(s1);
//		String s2 = new String("abc");
//		System.out.println(s1==s2);//false,地址不同
//		Object b = new String("abc");  //??
//		System.out.println("object "+b.toString());
//		
//		int[] a = {1,2,3};
//		int[] c = {1,2,3};
//		System.out.println(a.equals(c));
		
		Aoo a1 = new Aoo(10);
		Aoo a2 = new Aoo(10);
		System.out.println(a1==a2);
		System.out.println(a1.equals(a2));
		System.out.println(a1.hashCode()==a2.hashCode());
	}
}

class Aoo{
	int age;
	public Aoo(int age){
		this.age = age;
	}
	@Override
	public String toString() {
		return "Aoo [age=" + age + "]";
	}
	public boolean equals(Object obj){
		if(obj==null){return false;}
		if(this==obj){return true;}
		if(obj instanceof Aoo){
			Aoo aoo = (Aoo)obj;
			return this.age==aoo.age;
		}
		return false;
	}
}
























