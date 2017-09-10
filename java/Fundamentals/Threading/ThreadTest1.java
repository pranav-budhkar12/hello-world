class ThreadTest1{

	private static int count = 20;

	private static void helloProc(){
		for(int i = 1; i <= count; ++i){
			System.out.printf("Hello:%d from thread<%x>%n",
				i, Thread.currentThread().hashCode());
			Worker.doWork(i);
		}
	}

	private static void welcomeProc(){
		for(int i = count / 2; i > 0; i--){
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
	}
}















