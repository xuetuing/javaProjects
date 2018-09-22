package socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPSend {
	public static void main(String[] args) throws IOException {
		System.out.println("·¢ËÍ¶ËÆô¶¯..");
		DatagramSocket ds = new DatagramSocket();
		String str = "UDP´«ÊäÑÝÊ¾:É§Äï¶ù";
		byte[] buff = str.getBytes();
		InetAddress address = InetAddress.getLocalHost();
		//System.out.println(address.toString());
		DatagramPacket dp = new DatagramPacket(buff,buff.length,InetAddress.getByName("127.0.0.1"),8889);
		ds.send(dp);
		System.out.println("Send end!");
		ds.close();
		
	}
}
