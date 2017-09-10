import java.io.*;
import java.net.*;
import java.util.*;

class TCPServerTest1{

	private static String[] symbols = {"DELL", "GOGL", "INTC",
		"MSFT", "ORCL"};
	private static Random rdm = new Random();

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(2055);
		service(server);
	}

	private static void service(ServerSocket server) 
	throws IOException{
		for(;;){
			Socket client = server.accept();
			client.setSoTimeout(15000);
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			BufferedReader br = new BufferedReader(
				new InputStreamReader(in));
			PrintWriter pw = new PrintWriter(
				new OutputStreamWriter(out), true);
			try{
				pw.println("Welcome to stock-exchange server.");
				String symbol = br.readLine();
				int i = Arrays.binarySearch(symbols, symbol);
				if(i >= 0)
					pw.println("Price is " 
						+ (1000 + rdm.nextInt(9000)) / 100.0);
				else
					pw.println("Price not available");
			}catch(Exception e){}
			pw.close();
			br.close();
			client.close();
		}
	}
}













