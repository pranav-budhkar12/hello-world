class TryFinallyTest{

	public static void main(String[] args){
		try{
			run(args);
		}catch(Exception e){
			System.out.printf("ERROR: %s%n", e);
		}
	}

	private static void run(String[] args){
		System.out.println("Acquiring resources.");
		try{
			double value = Double.parseDouble(args[0]);
			System.out.printf("Square of %s is %f%n",
				args[0], value * value);
		}finally{
			System.out.println("Releasing resources.");
		}
	}
}

