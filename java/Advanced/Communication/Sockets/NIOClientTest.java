import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.channels.*;

class NIOClientTest{

	public static void main(String[] args) throws Exception{
		SocketAddress remote = new InetSocketAddress(args[0], 3055);
		SocketChannel client = SocketChannel.open();
		client.connect(remote);
		Charset cs = Charset.forName("UTF-8");
		ByteBuffer buffer = cs.encode(args[1]);
		client.write(buffer);
		buffer.clear();
		client.read(buffer);
		buffer.flip();
		System.out.printf("Response: %s%n", cs.decode(buffer));
		client.close();
	}
}


















