import java.io.*;
import java.net.*;
import java.util.*;
import com.sun.net.httpserver.*;

class HTTPServerTest{

	private static String[] symbols = {"DELL", "GOGL", "INTC",
		"MSFT", "ORCL"};
	private static Random rdm = new Random();
	
	public static void main(String[] args) throws Exception{
		HttpServer server = HttpServer.create(
			new InetSocketAddress(8055), 10);	
		server.createContext("/stock", new StockQuoteHandler());
		server.start();
	}

	static class StockQuoteHandler implements HttpHandler{
	
		public void handle(HttpExchange client) throws IOException{
			URI uri = client.getRequestURI();
			String symbol = uri.getQuery();
			String response = "Price not available";
			int i = Arrays.binarySearch(symbols, symbol);
			if(i >= 0)
				response = String.format("Price is %.2f\r\n",
					(1000 + rdm.nextInt(9000)) / 100.0);
			Headers rh = client.getResponseHeaders();
			rh.set("Content-type", "text/plain");
			client.sendResponseHeaders(200, 0);
			OutputStream out = client.getResponseBody();
			PrintWriter pw = new PrintWriter(out);
			pw.print(response);
			pw.close();
		}
	}
}

















