class GenMethodTest1{

	private static<T> T select(int sign, T first, T second){
		if(sign >= 0)
			return first;
		return second;
	}

	public static void main(String[] args){
		int s = Integer.parseInt(args[0]);
		String ss = select(s, "monday", "saturday");
		System.out.printf("Selected string = %s%n", ss);
		double sd = select(s, 12.3, 23.4);
		System.out.printf("Selected double = %s%n", sd);
		Interval si = select(s, new BigInterval(1, 2, 30),
			new Interval(4, 50));
		System.out.printf("Selected interval = %s%n", si);
		Long sl = select(s, 6789L, 0xABCDL);
		System.out.printf("Selected long = %s%n", sl);
	}

}














