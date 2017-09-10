class AutoBoxTest2{

	/*
	private static String select(int sign, String first, String second){
		if(sign >= 0)
			return first;
		return second;
	}

	private static double select(int sign, double first, double second){
		if(sign >= 0)
			return first;
		return second;
	}
	*/

	private static Object select(int sign, Object first, Object second){
		if(sign >= 0)
			return first;
		return second;
	}

	public static void main(String[] args){
		int s = Integer.parseInt(args[0]);
		String ss = (String) select(s, "monday", "saturday");
		System.out.printf("Selected string = %s%n", ss);
		double sd = (Double) select(s, 12.3, 23.4);
		System.out.printf("Selected double = %s%n", sd);
		Interval si = (Interval) select(s, new BigInterval(1, 2, 30),
			new Interval(4, 50));
		System.out.printf("Selected interval = %s%n", si);
		Long sl = (Long) select(s, 6789L, "ABCDL");
		System.out.printf("Selected long = %s%n", sl);
	}

}














