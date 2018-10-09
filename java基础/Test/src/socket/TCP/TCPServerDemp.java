package socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemp {
	public static void main(String[] args) throws IOException {
		System.out.println("服务端启动...");
		ServerSocket ss = new ServerSocket(8963);
		while(true){
			Socket sk = ss.accept();
			InputStream in = sk.getInputStream();
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			
			System.out.println("ip:"+sk.getInetAddress().getHostAddress());
			System.out.println(new String(buf,0,len));
			
			OutputStream out = sk.getOutputStream();
			out.write("收到".getBytes());
			sk.close();
		}
	}
}
