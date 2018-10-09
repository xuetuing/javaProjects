package day04;

public class Demo1 {
	public static void main(String[] args) {
//		User user = new User();
//		user.name = "李四";
//		user.age = 18;
		User user = new User("李四",18);
	}
}

class User{
	private String name;
	private int age;
	public User(){}  //要留一个无参构造器
	public User(String name,int age){
		this.name = name;
		this.age = age;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
}