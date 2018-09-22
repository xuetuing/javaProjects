package pattern;

interface Subject{
	//核心主题接口
	public void make();
}
class RealSubject implements Subject{
	public void make(){
		System.out.println("实现核心功能");
	}
}
class ProxySubject implements Subject{
	private Subject subject;
	public ProxySubject(Subject subject){
		this.subject = subject;
	}
	
	public void make(){
		this.prepare();
		this.subject.make();
		this.destroy();
	}
	public void prepare(){
		System.out.println("准备工作");
	}
	public void destroy(){
		System.out.println("收尾工作");
	}
}
public class ProxyDemo {
	public static void main(String[] args) {
		Subject sub = new ProxySubject(new RealSubject());
		sub.make();
	}
}
