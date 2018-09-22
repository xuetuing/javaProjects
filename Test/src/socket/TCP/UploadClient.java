package socket.TCP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class UploadClient {
	public static void main(String[] args) throws IOException, IOException {
		System.out.println("�ͻ�������...");
		//1.����ͻ���
		Socket sk = 
			new Socket(InetAddress.getLocalHost().getHostAddress(),8963);
		
		//2.���������ļ��������� 
		BufferedReader br = new BufferedReader(new FileReader("D:/Test/1.txt"));
		
		//3.�������뵽socket�������
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		//4.�ϴ��ϴ��ļ�
		String line = null;
		while((line=br.readLine())!=null)
			out.println(line);
		
		//5.�ر������
		sk.shutdownOutput();
		
		//6.�������˵ķ���
		BufferedReader buf = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		String str = buf.readLine();
		System.out.println(str);
		sk.close();
		
	}
}






















