interface Predicate{
	boolean allowed(int value);
}

class Algorithm{
	
	public static int addAll(int last){
		int total = 0;
		for(int i = 1; i <= last; ++i)
			total += i;
		return total;
	}

	public static int addIf(int last, Predicate check){
		int total = 0;
		for(int i = 1; i <= last; ++i){
			if(check.allowed(i))
				total += i;
		}
		return total;
	}
}

class TestPredicates{
	
	//Nested member class
	//Can only access static members of outer class
	//Can define static as well as non-static members
	static class EvenPredicate implements Predicate{
		
		public boolean allowed(int value){
			return (value % 2) == 0;
		}
	}

	//Inner member class
	//Can access static as well as non-static members of outer class
	//Can only define non-static members
	class OddPredicate implements Predicate{
		
		public boolean allowed(int value){
			return (value & 1) == 1;
		}
	}

}

class CallbackTest{

	public static void main(String[] args){
		int n = args.length < 1 ? 10 : Integer.parseInt(args[0]);
		int sum = Algorithm.addAll(n);
		System.out.printf("Sum of first %d integers is %d%n", n, sum);
		TestPredicates.EvenPredicate isEven =
			new TestPredicates.EvenPredicate();
		sum = Algorithm.addIf(n, isEven);
		System.out.printf("Sum of first %d even integers is %d%n", n, sum);
		TestPredicates.OddPredicate isOdd =
			new TestPredicates().new OddPredicate();
		sum = Algorithm.addIf(n, isOdd);
		System.out.printf("Sum of first %d odd integers is %d%n", n, sum);
		final int d = 3;
		//Passing an instance of an annonymous inner local class (closure)
		//that implements Predicate interface
		sum = Algorithm.addIf(n, new Predicate(){
			{
				System.out.println("Annonymous instance created");
			}

			public boolean allowed(int value){
				return (value % d) == 0;
			}
		});
		System.out.printf("Sum of first %d integers divisible by %d is %d%n"
			, n, d, sum);
	}
}














