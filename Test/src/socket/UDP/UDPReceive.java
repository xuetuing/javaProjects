package socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
//������ʾʱ�����ն��뷢�Ͷ����õĶ˿ڱ�����ͬ�����ն�������
public class UDPReceive {
	public static void main(String[] args) throws IOException {
		System.out.println("���ն�����...");
	
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
