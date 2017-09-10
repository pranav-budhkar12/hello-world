package edu.met.adsd.banking;

public interface Profitable{
	
	/**
 	Pays interest to this account.
	@param period duration for which interest is payed
	@return amount payed as interest
	*/
	double addInterest(int period);
}

