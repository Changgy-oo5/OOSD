package url;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IdEx {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		   InetAddress ip = InetAddress.getLocalHost();
	        System.out.println("Host Name: " + ip.getHostName());
	        System.out.println("IP Address: " + ip.getHostAddress());
	 
	        ip = InetAddress.getByName("www.w3schools.com");
	        System.out.println("\nHost Name: " + ip.getHostName());
	        System.out.println("IP Address: " + ip.getHostAddress());
	 
	        System.out.println("\nAll address of google: ");
	        InetAddress sw[] = InetAddress.getAllByName("www.google.com");
	        for (int i = 0; i < sw.length; i++) {
	            System.out.println(sw[i]);
	}
	        
	}
}


