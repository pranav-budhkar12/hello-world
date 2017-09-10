import shopping.*;
import java.rmi.*;
import java.util.*;
import javax.rmi.*;
import javax.naming.*;

class IIOPClientTest{

	public static void main(String[] args) throws Exception{
		Context naming = new InitialContext();
		Object ref = naming.lookup("cart");
		CartFactory factory = (CartFactory) PortableRemoteObject.narrow(
			ref, CartFactory.class);
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















