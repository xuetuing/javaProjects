package socket.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException, IOException {
		System.out.println("�ͷ�������...");
		Socket sc = 
			new Socket(InetAddress.getLocalHost().getHostAddress(),8963);
		OutputStream out = sc.getOutputStream();
		out.write("ɧ��������ˣ�".getBytes());
		sc.close();
	}
}
