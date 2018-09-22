package socket.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {
	public static void main(String[] args) throws IOException {
		//1.创建服务端
		ServerSocket ss = new ServerSocket(8963);
		
		//2.定义socket接收客户端的socket
		Socket sk = ss.accept();
		
		//获取ip
		String ip = sk.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected!");
		
		//3.定义socket输入流
		BufferedReader br = 
			new BufferedReader(new InputStreamReader(sk.getInputStream()));
		
		//4.定义用于输出到客户端的输出流
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		
		//5.处理信息
		String line = null;
		while((line=br.readLine())!=null){
			System.out.println(line);
			//输出到客户端
			out.println(line.toUpperCase());
		}
		sk.close();
		ss.close();
		
		
	}
}
