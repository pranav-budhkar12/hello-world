class ThreadTest2{

	static class GreeterThread extends Thread{
		
		private String message;
		private int count;

		public GreeterThread(String m, int n){
			message = m;
			count = n;
		}

		@Override
		public void run(){
			for(int i = 1; i <= count; ++i){
				System.out.printf("%s:%d from thread<%x>%n",
					message, i, Thread.currentThread().hashCode());
				Worker.doWork(i);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		Thread child = new GreeterThread("Hello", 20);
		child.setDaemon(true);
		child.start();
		for(int i = 10; i > 0; i--){
			System.out.printf("Welcome:%d from thread<%x>%n",
				i, Thread.currentThread().hashCode());
			Worker.doWork(i);
		}		
	}
}


















