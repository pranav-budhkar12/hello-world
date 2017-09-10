class Worker{

	public static void doWork(int n){
		long t = System.currentTimeMillis() + n;
		while(System.currentTimeMillis() < t);
	}
}












