import java.io.*;
import java.net.*;
import java.util.*;

class TCPServerTest2{

	private static String[] symbols = {"DELL", "GOGL", "INTC",
		"MSFT", "ORCL"};
	private static Random rdm = new Random();

	public static void main(String[] args) throws Exception{
		final ServerSocket server = new ServerSocket(2055);
		Runnable r = new Runnable(){
			public void run(){
				try{
					service(server);
				}catch(IOException e){}
			}
		};
		for(int i = 0; i < 3; ++i){
			Thread th = new Thread(r);
			th.start();
		}
	}

	private static void service(ServerSocket server) 
	throws IOException{
		for(;;){
			Socket client = server.accept();
			client.setSoTimeout(60000);
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













