package edu.met.adsd.banking;

public class Banker{
	
	private static long nextId;

	static{
		nextId = System.currentTimeMillis() % 1000000;
	}

	private Banker(){}

	public static Account openAccount(double amount, boolean current){
		Account acc;
		if(current)
			acc = new CurrentAccount();
		else
			acc = new SavingsAccount();
		acc.id += nextId++;
		acc.deposit(amount);
		return acc;
	}
}















