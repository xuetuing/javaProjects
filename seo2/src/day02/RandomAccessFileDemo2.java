package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo2 {
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try{
			raf = new RandomAccessFile("raf.dat","r");  //���쳣
			/*
			 * int read()
			 * ���ļ��ж�ȡһ���ֽڣ�����intֵ����ʽ����
			 * ��int ֵֻ�е�8λ��Ч��������-1��˵��EOF
			 * �ţϣƣ�end of file �ļ���ȡ��ĩβ
			 */
			System.out.println((char)raf.read());
			System.out.println((char)raf.read());
			byte[] strDate = new byte[9];
			/*
			 * int read(byte[] b)
			 * һ���Գ��Զ�ȡ�����ֽ����鳤�ȵ��ֽڣ���
			 * ���뵽�������ֽ������У�����ֵΪʵ�ʶ�ȡ�����ֽ���
			 */
			raf.read(strDate);
			String str = new String(strDate,"UTF-8");//String	���췽��
			System.out.println(str);
			/*
			 * int readInt()
			 * һ�ζ�ȡ4���ֽڣ�ƴ��Ϊint
			 */
			System.out.println(raf.readInt());
			System.out.println(raf.readInt());
			System.out.println(raf.readLong());
			System.out.println(raf.readChar());
			System.out.println(raf.readDouble());
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(raf!=null){
					raf.close();	//���쳣
				}
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		
		
	}
	
}
