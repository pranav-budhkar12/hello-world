import edu.met.adsd.banking.*;

class AdvOOPTest1{

	public static void main(String[] args){
		Account jack = Banker.openAccount(10000, true);
		Account jill = Banker.openAccount(5000, false);
		if(args.length > 0){
			try{
				double amt = Double.parseDouble(args[0]);
				jill.transfer(amt, jack);
			}catch(InsufficientFundsException e){
				System.out.println("Transfer failed: No funds.");
			}catch(Exception e){
				System.out.printf("ERROR: %s%n", e.getMessage());
			}
		}
		System.out.printf("Jack's Account ID is %s", jack.getId());
		System.out.printf(" and Balance is %.2f%n", jack.getBalance());
		System.out.printf("Jill's Account ID is %s", jill.getId());
		System.out.printf(" and Balance is %.2f%n", jill.getBalance());
	}
}

