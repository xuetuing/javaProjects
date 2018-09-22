package socket.TCP;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServerMThread {
	public static void main(String[] args) throws IOException {
		System.out.println("服务端启动...");
		//1.创建服务端
		ServerSocket ss = new ServerSocket(8963);
		//2.定义接收socket
		
		while(true){
			Socket sk = ss.accept();
			new Thread(new UploadTask(sk)).start();
		}
	}
	
}

class UploadTask implements Runnable{
	Socket sk;
	public UploadTask(Socket sk){
		this.sk = sk;
	}
	@Override
	public void run() {
		int count =0;
		//获得ip
		try {
		String ip = sk.getInetAddress().getHostAddress();
		System.out.println(ip+" is connected...");
		//创建文件夹存放文件
		File dir = new File("D:/Test/copy");
		if(!dir.exists())
			dir.mkdir();
		//3.定义接收客户端上传的文本和写出到文件的IO流
		InputStream is = sk.getInputStream();
		File file = new File(dir,ip+"("+(++count)+")"+".mp4");
		BufferedOutputStream bos= 
			new BufferedOutputStream(new FileOutputStream(file)); 
		
		//4.信息处理
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=is.read())!=-1){
			bos.write(buf,0,len);
			bos.flush();
		}
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		out.println("接收成功".getBytes());
		bos.close();
		sk.close();
		} catch (Exception e) {
		}
		
	}
	
	
}