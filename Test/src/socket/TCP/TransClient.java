package socket.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TransClient {
	public static void main(String[] args) throws IOException, IOException {
		Socket sk = 
			new Socket(InetAddress.getLocalHost().getHostAddress(),8963);
		//1.键盘输入流定义
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		//2.socket输入流定义
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		
		//3.接收服务器返回的输入流定义
		InputStream in = sk.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader bR = new BufferedReader(isr);
		
		//处理信息
		String line = null;
		while((line=br.readLine())!=null){
			out.println(line);
			if("over".equals(line))
				break;
			//服务器返回的大写字符
			System.out.println(bR.readLine());
				
		}
		sk.close();
	}
}
















