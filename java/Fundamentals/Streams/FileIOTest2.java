import java.io.*;

class FileIOTest2{

	private static void reverse(byte[] bytes){
		for(int i = 0, j = bytes.length - 1; i < j; ++i, j--){
			byte ib = bytes[i];
			byte jb = bytes[j];
			bytes[i] = jb;
			bytes[j] = ib;
		}
	}

	public static void main(String[] args) throws Exception{
		RandomAccessFile file = new RandomAccessFile(args[0], "rw");
		int n = (int) file.length();
		byte[] buffer = new byte[n];
		file.read(buffer);
		reverse(buffer);
		file.seek(0);
		file.write(buffer);
		file.close();
	}
}









