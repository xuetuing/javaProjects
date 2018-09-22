package socket.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {
	public static void main(String[] args) throws IOException {
		//1.���������
		ServerSocket ss = new ServerSocket(8963);
		
		//2.����socket���տͻ��˵�socket
		Socket sk = ss.accept();
		
		//��ȡip
		String ip = sk.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected!");
		
		//3.����socket������
		BufferedReader br = 
			new BufferedReader(new InputStreamReader(sk.getInputStream()));
		
		//4.��������������ͻ��˵������
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		
		//5.������Ϣ
		String line = null;
		while((line=br.readLine())!=null){
			System.out.println(line);
			//������ͻ���
			out.println(line.toUpperCase());
		}
		sk.close();
		ss.close();
		
		
	}
}
