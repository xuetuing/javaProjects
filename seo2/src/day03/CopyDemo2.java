package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//ʹ�û����ַ���������������ı��ļ�
public class CopyDemo2 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis =
			new FileInputStream("src"+File.separator+
					"day03"+File.separator+
					"CopyDemo2.java");
		InputStreamReader isr =
			new InputStreamReader(fis);
		BufferedReader br = 
			new BufferedReader(isr);
		
		FileOutputStream fos =
			new FileOutputStream("CopyDemo2.java");
		OutputStreamWriter osw =
			new OutputStreamWriter(fos);
		BufferedWriter bw =
			new BufferedWriter(osw);
		
		String line = null;
		while((line=br.readLine())!=null){
			bw.write(line);
			/*
			 * void newLine()
			 * ���һ����ǰϵͳ֧�ֵĻ��з�
			 */
			bw.newLine();
		}
		bw.close();
		br.close();
	}
}
