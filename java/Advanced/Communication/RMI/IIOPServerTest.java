import shopping.*;
import javax.naming.*;

class IIOPServerTest{

	public static void main(String[] args) throws Exception{
		Context naming = new InitialContext();
		CartFactoryImpl2 servant = new CartFactoryImpl2();
		naming.rebind("cart", servant);
	}
}

