import shopping.*;
import java.rmi.*;

class JRMPServerTest2{

	public static void main(String[] args) throws Exception{
		CartFactoryImpl1 servant = new CartFactoryImpl1();
		Naming.rebind("cart", servant);
	}
}

