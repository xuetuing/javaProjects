package socket.TCP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class UploadClientMThread {
	public static void main(String[] args) throws IOException, IOException {
		System.out.println("�ͻ�������...");
		//1.����ͻ���
		Socket sk = 
			new Socket(InetAddress.getLocalHost().getHostAddress(),8963);
		
		//2.���������ļ��������� 
		BufferedInputStream br = new BufferedInputStream(new FileInputStream("D:/Test/04039.mp4"));
		
		//3.�������뵽socket�������
		OutputStream out = sk.getOutputStream();
		//4.�ϴ��ϴ��ļ�
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=br.read())!=-1){
			out.write(buf,0,len);
			out.flush();
		}
		//5.�ر������
		sk.shutdownOutput();
		//6.�������˵ķ���
		BufferedReader info = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		String str = info.readLine();
		System.out.println(str);
		sk.close();
	}
}
