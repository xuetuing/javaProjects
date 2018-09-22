package socket.TCP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class UploadClient {
	public static void main(String[] args) throws IOException, IOException {
		System.out.println("客户端启动...");
		//1.定义客户端
		Socket sk = 
			new Socket(InetAddress.getLocalHost().getHostAddress(),8963);
		
		//2.定义来自文件的输入流 
		BufferedReader br = new BufferedReader(new FileReader("D:/Test/1.txt"));
		
		//3.定义输入到socket的输出流
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		//4.上传上传文件
		String line = null;
		while((line=br.readLine())!=null)
			out.println(line);
		
		//5.关闭输出流
		sk.shutdownOutput();
		
		//6.处理服务端的反馈
		BufferedReader buf = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		String str = buf.readLine();
		System.out.println(str);
		sk.close();
		
	}
}






















