package socket.TCP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class UploadClientMThread {
	public static void main(String[] args) throws IOException, IOException {
		System.out.println("客户端启动...");
		//1.定义客户端
		Socket sk = 
			new Socket(InetAddress.getLocalHost().getHostAddress(),8963);
		
		//2.定义来自文件的输入流 
		BufferedInputStream br = new BufferedInputStream(new FileInputStream("D:/Test/04039.mp4"));
		
		//3.定义输入到socket的输出流
		OutputStream out = sk.getOutputStream();
		//4.上传上传文件
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=br.read())!=-1){
			out.write(buf,0,len);
			out.flush();
		}
		//5.关闭输出流
		sk.shutdownOutput();
		//6.处理服务端的反馈
		BufferedReader info = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		String str = info.readLine();
		System.out.println(str);
		sk.close();
	}
}
