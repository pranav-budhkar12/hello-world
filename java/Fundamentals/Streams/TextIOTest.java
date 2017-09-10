import java.io.*;

class TextIOTest{

	public static void main(String[] args) throws Exception{
		if(args.length > 2){
			short stock = Short.parseShort(args[0]);
			float price = Float.parseFloat(args[1]);
			String name = args[2].toUpperCase();
			PrintWriter pw = new PrintWriter(
				new OutputStreamWriter(
				new FileOutputStream("product.txt")));
			pw.println(stock);
			pw.println(price);
			pw.println(name);
			pw.close();
		}else{
			BufferedReader br = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("product.txt")));
			short stock = Short.parseShort(br.readLine());
			float price = Float.parseFloat(br.readLine());
			String name = br.readLine();
			br.close();
			System.out.printf("%d %.2f %s%n", stock, price, name);
		}
	}

}














