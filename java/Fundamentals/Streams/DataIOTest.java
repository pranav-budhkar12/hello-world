import java.io.*;

class DataIOTest{

	public static void main(String[] args) throws Exception{
		if(args.length > 2){
			short stock = Short.parseShort(args[0]);
			float price = Float.parseFloat(args[1]);
			String name = args[2].toUpperCase();
			DataOutputStream dout = new DataOutputStream(
				new FileOutputStream("product.dat"));
			dout.writeShort(stock);
			dout.writeFloat(price);
			dout.writeUTF(name);
			dout.close();
		}else{
			DataInputStream din = new DataInputStream(
				new FileInputStream("product.dat"));
			short stock = din.readShort();
			float price = din.readFloat();
			String name = din.readUTF();
			din.close();
			System.out.printf("%d %.2f %s%n", stock, price, name);
		}
	}

}














