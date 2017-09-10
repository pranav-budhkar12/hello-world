class Interval{

	private int minutes;
	private int seconds;
	private int id;
	private static int count;

	public Interval(int m, int s){
		minutes = m + s / 60;
		seconds = s % 60;
		id = ++count;
	}

	public final int getMinutes(){
		return minutes;
	}

	public final int getSeconds(){
		return seconds;
	}

	public Interval add(Interval other){
		return new Interval(minutes + other.minutes,
			seconds + other.seconds);
	}

	public String toString(){
		String result = minutes + ":";
		if(seconds < 10)
			result += "0";
		result += seconds;
		return result;
	}

	public int hashCode(){
		return 60 * minutes + seconds;
	}

	public boolean equals(Object other){
		if(other instanceof Interval){
			Interval that = (Interval) other;
			return (this.minutes == that.minutes)
				&& (this.seconds == that.seconds);
		}
		return false;
	}
	
}

















