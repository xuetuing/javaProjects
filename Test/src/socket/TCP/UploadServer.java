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
		System.out.println("服务端启动...");
		//1.创建服务端
		ServerSocket ss = new ServerSocket(8963);
		//2.定义接收socket
		Socket sk = ss.accept();
		
		//获得ip
		String ip = sk.getInetAddress().getHostAddress();
		System.out.println(ip+" is connected...");
		//3.定义接收客户端上传的文本和写出到文件的IO流
		BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Test/server.txt")); 
		
		//4.信息处理
		String line = null;
		while((line=br.readLine())!=null){
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		out.println("接收成功");
		sk.close();
		ss.close();
		
	}
}
