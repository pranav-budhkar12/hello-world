import java.io.*;
import java.net.*;

class TCPClientTest{

	public static void main(String[] args) throws Exception{
		Socket client = new Socket(args[0], 2055);
		BufferedReader br = new BufferedReader(
			new InputStreamReader(client.getInputStream()));
		PrintWriter pw = new PrintWriter(
			new OutputStreamWriter(client.getOutputStream()));
		System.out.println(br.readLine());
		pw.println(args[1]);
		pw.flush();
		System.out.println(br.readLine());
		pw.close();
		br.close();
		client.close();
	}
}

