package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

//�ļ��ֽ�������
public class FISDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * FileInputStream(File file)
		 * FileInputStream(String fileName)
		 */
		FileInputStream fis = new FileInputStream("fos.dat");
		/*
		 * int read()
		 * ��ȡһ���ֽڣ�����int����ʽ���أ�"��8λ"��Ч
		 * ������-1��˵��EOF
		 */
		System.out.println((char)fis.read());
		//System.out.println(fis.read());
		
		/*
		 * int read(byte[] b)
		 * һ���Գ��Զ�ȡ���������鳤�ȵ��ֽ����������������������
		 * ����ֵΪʵ�ʶ�ȡ�����ֽ���
		 */
		byte[] array = new byte[100];
		int len = fis.read(array);

		String str = new String(array,0,len,"UTF-8");
		System.out.println(len);
		System.out.println(str);
		//System.out.println(Arrays.toString(array));
		/*
		 * String(byte[] b,int start,int len,String csn)
		 */
		//String str = new String(array,"UTF-8");
//		String str = new String(array,0,len,"UTF-8");
//		System.out.println(str);
		/*
		 * int read(byte[] b,int start,int len)
		 * �Ӹ���������ȡlen���ֽڲ��Ӹ����ֽ������start����ʼ����
		 */
		
		
		
		fis.close();
		
	}
}
































