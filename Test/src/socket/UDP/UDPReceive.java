package socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
//本机演示时，接收端与发送端设置的端口必须相同，接收端先启动
public class UDPReceive {
	public static void main(String[] args) throws IOException {
		System.out.println("接收端启动...");
	
		DatagramSocket ds = new DatagramSocket(8889);
		byte[] buff = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buff,buff.length);
		System.out.println("I am waiting!");
		ds.receive(dp);
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		String msg = new String(dp.getData(),0,dp.getLength());
		System.out.println(ip+","+port+","+msg);
		ds.close();
	}
}
