package socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientDemo {
	public static void main(String[] args) throws IOException, IOException {
		System.out.println("�ͻ�������...");
		Socket sk = 
			new Socket(InetAddress.getLocalHost().getHostAddress(),8963);
		OutputStream out = sk.getOutputStream();
		out.write("ɧ���������!".getBytes());
		InputStream in = sk.getInputStream();
		byte[] buf = new byte[1024];
		int len=in.read(buf);
		System.out.println(new String(buf,0,len));
	
		sk.close();
	}
}
