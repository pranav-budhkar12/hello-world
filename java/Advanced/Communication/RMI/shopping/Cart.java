package shopping;

import java.rmi.*;

public interface Cart extends Remote{

	boolean buyItem(String item) throws RemoteException;
	
	double checkOut() throws RemoteException;

}

