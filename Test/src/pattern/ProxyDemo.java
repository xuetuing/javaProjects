package pattern;

interface Subject{
	//��������ӿ�
	public void make();
}
class RealSubject implements Subject{
	public void make(){
		System.out.println("ʵ�ֺ��Ĺ���");
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
		System.out.println("׼������");
	}
	public void destroy(){
		System.out.println("��β����");
	}
}
public class ProxyDemo {
	public static void main(String[] args) {
		Subject sub = new ProxySubject(new RealSubject());
		sub.make();
	}
}
