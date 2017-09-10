package basicwebapp;

public class CounterBean implements java.io.Serializable{

	private long count;
	private long step;

	public CounterBean(){
		count = 0;
		step = 1;
	}

	public final long getStep(){
		return step;
	}

	public final void setStep(long value){
		step = value;
	}

	public synchronized long getNextCount(){
		return count += step;
	}
}















