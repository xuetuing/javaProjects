package day01;

public class ExceptionDemo4 {
	public static void main(String[] args) {
		connectDB("admin","12356");
		System.out.println("��ϲ��¼�ɹ�");
	}
	
	public static void connectDB(String user,String pwd){
		if("admin".equals(user)&&"123456".equals(pwd)){
			System.out.println("�������ݿ�ɹ�");
		}else{
			//ģ��ϵͳ�׳�һ���������ݿ�ʧ�ܵ��쳣 
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}
	
	
}
