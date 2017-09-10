import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.*;
import java.nio.channels.*;

class NIOServerTest{

	public static void main(String[] args) throws Exception{
		Selector selector = Selector.open();
		SocketAddress local = new InetSocketAddress(3055);
		ServerSocketChannel server = ServerSocketChannel.open();
		server.socket().bind(local);
		server.configureBlocking(false);
		server.register(selector, SelectionKey.OP_ACCEPT);
		while(selector.select() > 0){
			Iterator<SelectionKey> i = selector.selectedKeys().iterator();
			while(i.hasNext()){
				SelectionKey key = i.next();
				if(key.isAcceptable()){
					ServerSocketChannel channel = 
						(ServerSocketChannel) key.channel();
					SocketChannel client = channel.accept();
					client.configureBlocking(false);
					client.register(selector, SelectionKey.OP_READ);
				}else if(key.isReadable()){
					SocketChannel channel = 
						(SocketChannel) key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(80);
					int n = channel.read(buffer);
					buffer.flip();
					for(int j = 0; j < n; ++j){
						byte jb = buffer.get(j);
						byte eb = (byte) (jb ^ '#');
						buffer.put(j, eb);
					}
					channel.write(buffer);
					channel.close();
				}
				i.remove();
			}
		}
	}
}

















