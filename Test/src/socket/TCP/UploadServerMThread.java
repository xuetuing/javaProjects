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
		System.out.println("���������...");
		//1.���������
		ServerSocket ss = new ServerSocket(8963);
		//2.�������socket
		
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
		//���ip
		try {
		String ip = sk.getInetAddress().getHostAddress();
		System.out.println(ip+" is connected...");
		//�����ļ��д���ļ�
		File dir = new File("D:/Test/copy");
		if(!dir.exists())
			dir.mkdir();
		//3.������տͻ����ϴ����ı���д�����ļ���IO��
		InputStream is = sk.getInputStream();
		File file = new File(dir,ip+"("+(++count)+")"+".mp4");
		BufferedOutputStream bos= 
			new BufferedOutputStream(new FileOutputStream(file)); 
		
		//4.��Ϣ����
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=is.read())!=-1){
			bos.write(buf,0,len);
			bos.flush();
		}
		PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
		out.println("���ճɹ�".getBytes());
		bos.close();
		sk.close();
		} catch (Exception e) {
		}
		
	}
	
	
}