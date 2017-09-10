import java.util.*;

class IterationTest{

	static class LottoStateMachine implements Iterable<Integer>{
		
		private int digits;
		private Random rdm;

		public LottoStateMachine(int digits){
			this.digits = digits;
			rdm = new Random();
		}

		private int pickNextDigit(){
			long t = System.currentTimeMillis() + 1000;
			while(System.currentTimeMillis() < t);
			return rdm.nextInt(10);
		}

		public Iterator<Integer> iterator(){
			return new Iterator<Integer>(){
				int count = digits;

				public boolean hasNext(){
					return count > 0;
				}

				public Integer next(){
					count--;
					return pickNextDigit();
				}

				public void remove(){}
			};
		}
	}

	public static void main(String[] args){
		LottoStateMachine lotto = new LottoStateMachine(8);
		System.out.print("WINNER:");
		for(int digit : lotto)
			System.out.printf(" %d", digit);
		System.out.println();
	}
}














