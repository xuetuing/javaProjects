package socket.TCP;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class UploadServerSThread {
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
		InputStream is = sk.getInputStream();
		BufferedOutputStream bos= 
			new BufferedOutputStream(new FileOutputStream("D:/Test/server.mp4")); 
		//FileOutputStream fos= new FileOutputStream("D:/Test/server.mp4");
		//4.信息处理
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=is.read(buf))!=-1){
			bos.write(buf,0,len);
			bos.flush();
		}
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		out.println("接收成功");
		sk.close();
		ss.close();
		bos.close();
	}
}
