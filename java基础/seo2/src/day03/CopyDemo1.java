package day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//ʹ���ַ��������ı��ļ�
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		//������ǰ�����Դ���뵽��Ŀ�ĸ�Ŀ¼
		FileInputStream fis =
			new FileInputStream("src"+File.separator+
					"day03"+File.separator+
					"CopyDemo1.java");
		FileOutputStream fos =
			new FileOutputStream("CopyDemo1.java");
		InputStreamReader isr =
			new InputStreamReader(fis);
		OutputStreamWriter osw =
			new OutputStreamWriter(fos);
		int c = -1;
		while((c=isr.read())!=-1){
			osw.write(c);
		}
		System.out.println("�������");
		isr.close();
		osw.close();
	}
}
