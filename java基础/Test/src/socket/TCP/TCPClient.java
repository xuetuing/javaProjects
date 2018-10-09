package socket.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException, IOException {
		System.out.println("客服端启动...");
		Socket sc = 
			new Socket(InetAddress.getLocalHost().getHostAddress(),8963);
		OutputStream out = sc.getOutputStream();
		out.write("骚娘儿又来了！".getBytes());
		sc.close();
	}
}
