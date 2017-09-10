import java.io.*;
import java.nio.*;
import java.nio.channels.*;

class NewIOTest{

	private static void reverse(ByteBuffer bytes){
		for(int i = 0, j = bytes.capacity() - 1; i < j; ++i, j--){
			byte ib = bytes.get(i);
			byte jb = bytes.get(j);
			bytes.put(i, jb);
			bytes.put(j, ib);
		}
	}

	public static void main(String[] args) throws Exception{
		RandomAccessFile file = new RandomAccessFile(args[0], "rw");
		int n = (int) file.length();
		FileChannel channel = file.getChannel();
		FileLock lock = channel.lock();
		ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE,
			0, n);
		reverse(buffer);
		lock.release();
		channel.close();
		file.close();
	}
}












