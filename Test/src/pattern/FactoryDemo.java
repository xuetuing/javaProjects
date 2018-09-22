package pattern;

interface Fruit{
	public abstract void eat();
}
class Apple implements Fruit{
	public void eat(){
		System.out.println("*** ³ÔÆ»¹û");
	}
}
class orange implements Fruit{
	public void eat(){
		System.out.println("*** ³ÔéÙ×Ó");
	}
}
class Factory{
	public static Fruit getInstance(String className){
		if("Apple".equals(className)){
			return new Apple();
		}else if("orange".equals(className)){
			return new orange();
		}else{
			return null;
		}
	}
}
public class FactoryDemo {
	public static void main(String[] args) {
		Fruit f = Factory.getInstance("Apple");
		f.eat();
	}
}















