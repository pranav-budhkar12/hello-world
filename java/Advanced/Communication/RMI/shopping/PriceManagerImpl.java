package shopping;

import java.rmi.*;
import java.util.*;

public class PriceManagerImpl 
extends java.rmi.server.UnicastRemoteObject
implements PriceManager{

	public PriceManagerImpl() throws RemoteException{
		super(); // exports this object
	}

	public double getUnitPrice(String item){
		int i = Arrays.binarySearch(Store.items, item);
		if(i < 0)
			throw new RuntimeException("No such item");
		return 1.05 * Store.prices[i];
	}

	public float getBulkDiscount(int quantity){
		return quantity < 12 ? 0 : 10;
	}
	
}

class Store{

	static String[] items = {"apple", "mango", "orange", "peach", "pear"};
	static double[] prices = {20.25, 30.75, 5.50, 3.25, 4.75};
}

















