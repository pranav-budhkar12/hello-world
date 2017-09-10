import java.util.*;

class ArrayListTest{

	public static void main(String[] args){
		List<Interval> store = new ArrayList<Interval>();
		store.add(new Interval(3, 21));
		store.add(new Interval(5, 12));
		store.add(new Interval(7, 33));
		store.add(new Interval(6, 24));
		store.add(new Interval(4, 35));
		store.add(new Interval(2, 81));
		for(Interval i : store)
			System.out.println(i);
		System.out.printf("Third interval => %s%n", store.get(2));
	}
}


















