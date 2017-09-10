class TryCatchTest{

	public static void main(String[] args){
		run(args);
		System.out.println("Goodbye.");
	}

	private static void run(String[] args){
		try{
			double value = Double.parseDouble(args[0]);
			System.out.printf("Square of %s is %f%n",
				 args[0], value * value);
		}catch(NumberFormatException e){
			System.out.println("ERROR: Illegal input");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ERROR: No input");
		}
	}
}

