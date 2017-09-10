package shopping;

import java.rmi.*;
import java.util.*;

public class CartImpl2 extends javax.rmi.PortableRemoteObject
implements Cart{
	
	private double payment = 0;

	public CartImpl2() throws RemoteException{}

	public boolean buyItem(String item){
		int i = Arrays.binarySearch(Store.items, item);
		if(i < 0) return false;
		payment += Store.prices[i];
		return true;
	}

	public double checkOut() throws RemoteException{
		unexportObject(this);
		return 1.05 * payment;
	}
}
















