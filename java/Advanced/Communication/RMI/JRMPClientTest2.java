import shopping.*;
import java.rmi.*;
import java.util.*;

class JRMPClientTest2{

	public static void main(String[] args) throws Exception{
		CartFactory factory = (CartFactory) Naming.lookup(
			"rmi://fedguest/cart");
		Cart cart = factory.create();
		Scanner input = new Scanner(System.in);
		for(int n = 1;; ++n){
			System.out.printf("Item %d: ", n);
			String i = input.next();
			if(i.equals("done")) break;
			System.out.printf("Adding %s to your cart...", i);
			if(cart.buyItem(i))
				System.out.println("Succeeded.");
			else
				System.out.println("Failed!");
		}
		System.out.printf("Total payment: %.2f%n",
			cart.checkOut());
	}
}















