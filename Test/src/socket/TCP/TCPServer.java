package socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException {
		System.out.println("���������...");
		ServerSocket ss = new ServerSocket(8963);
		Socket sk = ss.accept();
		InputStream is = sk.getInputStream();
		byte[] buf = new byte[1024];
		int ch;
		while((ch=is.read(buf))!=-1){
			String msg = new String(buf,0,ch);
			System.out.println(msg);
		}
		sk.close();
		ss.close(); //һ�㲻�رգ����ܶ�η���
		
	}
}
