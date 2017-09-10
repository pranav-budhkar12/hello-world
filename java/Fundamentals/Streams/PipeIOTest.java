import java.io.*;

class PipeIOTest{

	public static void main(String[] args) throws Exception{
		PipedOutputStream pout = new PipedOutputStream();
		final PipedInputStream pin = new PipedInputStream(pout);
		Thread consumer = new Thread(new Runnable(){
			public void run(){
				try{
					int value;
					do{
						value = pin.read();
						System.out.printf("Processed value = %d%n",
							value * value);
					}while(value != 0);
				}catch(IOException e){}
			}
		});
		consumer.start();
		for(int i = 10; i >= 0; i--){
			Thread.sleep(100 * i + 10);
			pout.write(i);
			pout.flush();
		}
		consumer.join();
		pin.close();
		pout.close();
	}
}














