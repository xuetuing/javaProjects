package socket;

import java.net.InetAddress;

public class IpAddress {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
//			String ip = address.getHostAddress();
//			String hname = address.getHostName();
			address = InetAddress.getByName("EKJ8CH45ZSOJSCI");
//			System.out.println(ip);
//			System.out.println(hname);
			System.out.println(address.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//172.17.15.72
		//EKJ8CH45ZSOJSCI

		
	}
}
