package socket.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPThreadDemo {
	public static void main(String[] args) throws IOException{
		DatagramSocket send = new DatagramSocket();
		Send se = new Send(send);
				
		DatagramSocket rec = new DatagramSocket(8963);
		Rec re = new Rec(rec);
		
		new Thread(re).start();
		new Thread(se).start();
		
	}
	
}

class Send implements Runnable{
	DatagramSocket ds;
	
	public Send(DatagramSocket ds){
		this.ds = ds;		
	}
	@Override
	public void run() {
		System.out.println("发送端启动...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while((line=br.readLine())!=null){
				byte[] buf = line.getBytes();
				DatagramPacket dp = 
					new DatagramPacket(buf,buf.length,InetAddress.getLocalHost(),8963);
				ds.send(dp);
				if("886".equals(line))
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ds.close();
	}
	
	
}

class Rec implements Runnable{
	DatagramSocket ds;
	public Rec(DatagramSocket ds){
		this.ds = ds;
	}
	@Override
	public void run() {
		System.out.println("接收端启动...");
		byte[] buf = new byte[1024];
		DatagramPacket rec = new DatagramPacket(buf,buf.length);
		try {
			while(true){
				ds.receive(rec);
				String addr = rec.getAddress().getHostAddress();
				int port = rec.getPort();
				String msg = new String(rec.getData(),0,rec.getLength());
				System.out.println(addr+":"+port+":"+msg);
				if(msg.equals("886")){
					System.out.println("退出聊天室");
					break;
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
}