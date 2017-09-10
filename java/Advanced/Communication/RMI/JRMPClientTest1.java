import shopping.*;
import java.rmi.*;
import java.util.*;

class JRMPClientTest1{

	public static void main(String[] args) throws Exception{
		String url = args.length > 0 
			? args[0] : "rmi://localhost/priceManager";
		PriceManager remote = (PriceManager) Naming.lookup(url);
		Scanner input = new Scanner(System.in);
		try{
			System.out.print("Item: ");
			String i = input.next();
			double p = remote.getUnitPrice(i);
			System.out.print("Quantity: ");
			int q = input.nextInt();
			float d = remote.getBulkDiscount(q);
			System.out.printf("Total payment: %.2f%n",
				p * q * (1 - d / 100));
		}catch(Exception e){
			System.out.printf("ERROR: %s%n", e);
		}
	}
}






















