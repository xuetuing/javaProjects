package day01;
/*
 * finally ��Զ�ᱻִ��
 * NullPointerException
 * StringIndexOutOfBoundsException
 * ArrayIndexOutOfBoundsException
 * ....������RuntimeException-->Exception
 * catch�쳣���쳣��С���󣬷������ֱ������
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println(test(null)+","+test("0")+","+test(""));
	}
	public static int test(String str){
		try{
			return str.charAt(0)-'0';
		} catch (NullPointerException e){
			return 1;
		} catch (RuntimeException e){
			return 2;
		} catch (Exception e){
			return 3;
		} finally{
			//finally�в�����ʹ��return���
			return 4;
		}
	}
	
}
