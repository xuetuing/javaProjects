package day04;

public class Demo1 {
	public static void main(String[] args) {
//		User user = new User();
//		user.name = "����";
//		user.age = 18;
		User user = new User("����",18);
	}
}

class User{
	private String name;
	private int age;
	public User(){}  //Ҫ��һ���޲ι�����
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