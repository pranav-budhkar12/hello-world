class ThreadRaceTest{

	static class JointAccount{
		
		private int id;
		private int balance;
		private static int count;

		public JointAccount(){
			id = 1001 + count++;
			balance = 5000;
		}

		public int getId(){
			return id;
		}

		public int getBalance(){
			return balance;
		}

		public void deposit(int amount){
			Worker.doWork(amount / 100);
			balance += amount;
		}

		public boolean withdraw(int amount){
			boolean result = false;
			if(balance >= amount){
				Worker.doWork(amount / 100);
				balance -= amount;
				result = true;
			}
			return result;
		}
	}

	public static void main(String[] args) throws Exception{
		final JointAccount acc = new JointAccount();
		System.out.printf(
			"Joint-Account with ID %d opened for Jack and Jill%n",
			acc.getId());
		System.out.printf("Initial balance: %d%n", acc.getBalance());
		Thread th = new Thread(new Runnable(){
			public void run(){
				System.out.println(
					"Jill is withdrawing 4000 from Joint-Account");
				if(acc.withdraw(4000) == false)
					System.out.println("Jill's withdraw operation failed!");
			}
		});
		th.start();
		System.out.println("Jack is withdrawing 3000 from Joint-Account");
		if(acc.withdraw(3000) == false)
			System.out.println("Jack's withdraw operation failed!");
		th.join();
		System.out.printf("Final balance: %d%n", acc.getBalance());
	}
}















