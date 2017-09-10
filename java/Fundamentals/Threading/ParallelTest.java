import java.util.concurrent.*;

class ParallelTest{

	public static void main(String[] args) throws Exception{
		ExecutorService parallel = Executors.newFixedThreadPool(2);
		Future<Integer> result1 = parallel.submit(new Callable<Integer>(){
			public Integer call(){
				int sum = 0;
				for(int i = 1; i <= 25; ++i){
					System.out.printf(
						"Processing value %d in thread<%x>%n", i,
						Thread.currentThread().hashCode());
					Worker.doWork(i);
					sum += i * i;
				}
				return sum;
			}
		});
		Future<Integer> result2 = parallel.submit(new Callable<Integer>(){
			public Integer call(){
				int sum = 0;
				for(int i = 26; i <= 50; ++i){
					System.out.printf(
						"Processing value %d in thread<%x>%n", i,
						Thread.currentThread().hashCode());
					Worker.doWork(i);
					sum += i * i;
				}
				return sum;
			}
		});
		int result = result1.get() + result2.get();
		System.out.printf("Result = %d%n", result);
		parallel.shutdown();
	}
}











