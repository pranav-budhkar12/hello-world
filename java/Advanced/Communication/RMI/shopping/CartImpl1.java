package shopping;

import java.rmi.*;
import java.util.*;

public class CartImpl1 extends java.rmi.server.UnicastRemoteObject
implements Cart{
	
	private double payment = 0;

	public CartImpl1() throws RemoteException{}

	public boolean buyItem(String item){
		int i = Arrays.binarySearch(Store.items, item);
		if(i < 0) return false;
		payment += Store.prices[i];
		return true;
	}

	public double checkOut(){
		return 1.05 * payment;
	}
}
















