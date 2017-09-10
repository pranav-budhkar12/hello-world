class GenMethodTest2{

	private static<T extends Comparable<T>> T maximum(T first, T second){
		if(first.compareTo(second) > 0)
			return first;
		return second;
	}

	public static void main(String[] args){
		double md = maximum(76.54, 65.43);
		System.out.printf("Maximum double = %s%n", md);
		String ms = maximum("monday", "friday");
		System.out.printf("Maximum string = %s%n", ms);
		Interval mi = maximum(new Interval(2, 30), new Interval(3, 20));
		System.out.printf("Maximum interval = %s%n", mi);
	}

}

