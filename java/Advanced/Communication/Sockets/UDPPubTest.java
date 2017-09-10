import java.net.*;
import java.util.*;

class UDPPubTest{

	private static String[] symbols = {"DELL", "GOGL", "INTC",
		"MSFT", "ORCL"};
	private static Random rdm = new Random();

	public static void main(String[] args) throws Exception{
		InetAddress group = InetAddress.getByName("230.0.0.1");
		DatagramSocket publisher = new DatagramSocket();
		for(;;){
			int i = rdm.nextInt(symbols.length);
			String text = String.format("%s : %.2f", 
				symbols[i], (1000 + rdm.nextInt(9000)) / 100.0);
			DatagramPacket packet = new DatagramPacket(
				text.getBytes(), text.length(), group, 2056);
			publisher.send(packet);
			Thread.sleep(10000);
		}
	}
}

















