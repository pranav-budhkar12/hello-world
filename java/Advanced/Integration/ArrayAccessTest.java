class ArrayHelper{
	
	public native static double sumOf(double[] entries);

	public native static void squareAll(double[] entries);

	static{
		System.loadLibrary("arrh");
	}
}

class ArrayAccessTest{

	public static void main(String[] args) throws Exception{
		double[] list = new double[args.length];
		for(int i = 0; i < list.length; ++i)
			list[i] = Double.parseDouble(args[i]);
		System.out.printf("Sum of values = %s%n",
			ArrayHelper.sumOf(list));
		ArrayHelper.squareAll(list);
		System.out.printf("Sum of squares = %s%n",
			ArrayHelper.sumOf(list));
	}

}
















