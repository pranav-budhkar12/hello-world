import shopping.*;
import java.rmi.*;

class JRMPServerTest1{

	public static void main(String[] args) throws Exception{
		PriceManagerImpl servant = new PriceManagerImpl();
		Naming.rebind("priceManager", servant);
	}
}

