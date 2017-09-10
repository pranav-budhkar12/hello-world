class ThreadSleepTest{

	private static int count = 20;

	private static void helloProc(){
		for(int i = 1; i <= count / 2; ++i){
			System.out.printf("Hello:%d from thread<%x>%n",
				i, Thread.currentThread().hashCode());
			Worker.doWork(i);
		}
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			System.out.println("Sleep interrupted!");
		}
		System.out.println("Goodbye");
	}

	private static void welcomeProc(){
		for(int i = count; i > 0; i--){
			System.out.printf("Welcome:%d from thread<%x>%n",
				i, Thread.currentThread().hashCode());
			Worker.doWork(i);
		}
	}

	public static void main(String[] args) throws Exception{
		Thread child = new Thread(new Runnable(){
			public void run(){
				helloProc();
			}
		});
		child.start();
		welcomeProc();
		child.interrupt();
	}
}















