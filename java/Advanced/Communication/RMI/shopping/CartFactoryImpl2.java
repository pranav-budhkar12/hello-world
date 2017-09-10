package shopping;

import java.rmi.*;

public class CartFactoryImpl2 extends javax.rmi.PortableRemoteObject
implements CartFactory{

	public CartFactoryImpl2() throws RemoteException{}

	public Cart create() throws RemoteException{
		return new CartImpl2();
	}
	
}

