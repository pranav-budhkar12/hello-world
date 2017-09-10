import java.io.*;
import java.net.*;

class URLTest{

	public static void main(String[] args) throws Exception{
		String site = String.format("http://%s:8055/stock?%s",
			args[0], args[1]);
		URL url = new URL(site);
		InputStream in = url.openStream();
		BufferedReader br = new BufferedReader(
			new InputStreamReader(in));
		System.out.println(br.readLine());
		br.close();
	}
}

