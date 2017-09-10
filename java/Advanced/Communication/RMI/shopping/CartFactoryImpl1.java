package shopping;

import java.rmi.*;

public class CartFactoryImpl1 extends java.rmi.server.UnicastRemoteObject
implements CartFactory{

	public CartFactoryImpl1() throws RemoteException{}

	public Cart create() throws RemoteException{
		return new CartImpl1();
	}
	
}

