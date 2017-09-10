package edu.met.adsd.banking;

final class SavingsAccount extends Account implements Profitable{
	
	static final double MIN_BALANCE = 5000;

	public SavingsAccount(){
		id = "S/A";
		balance = MIN_BALANCE;
	}

	public void deposit(double amount){
		balance += amount;
	}

	public void withdraw(double amount)
	throws InsufficientFundsException{
		if(balance - amount < MIN_BALANCE)
			throw new InsufficientFundsException();
		balance -= amount;
	}

	public double addInterest(int period){
		float rate = balance < 10000 ? 4.0f : 4.5f;
		double interest = balance * period * rate / 100;
		balance += interest;
		return interest;
	}
}

















