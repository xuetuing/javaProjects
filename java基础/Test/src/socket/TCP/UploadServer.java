package socket.TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
	public static void main(String[] args) throws IOException {
		System.out.println("���������...");
		//1.���������
		ServerSocket ss = new ServerSocket(8963);
		//2.�������socket
		Socket sk = ss.accept();
		
		//���ip
		String ip = sk.getInetAddress().getHostAddress();
		System.out.println(ip+" is connected...");
		//3.������տͻ����ϴ����ı���д�����ļ���IO��
		BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Test/server.txt")); 
		
		//4.��Ϣ����
		String line = null;
		while((line=br.readLine())!=null){
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		out.println("���ճɹ�");
		sk.close();
		ss.close();
		
	}
}
