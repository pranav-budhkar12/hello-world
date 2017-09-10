import java.util.*;

class TreeSetTest2{

	public static void main(String[] args){
		Set<Interval> store = new TreeSet<Interval>(
			new Comparator<Interval>(){
				public int compare(Interval first, Interval second){
					return first.getSeconds() - second.getSeconds();
				}
			});
		store.add(new Interval(3, 21));
		store.add(new Interval(5, 12));
		store.add(new Interval(7, 33));
		store.add(new Interval(6, 24));
		store.add(new Interval(4, 35));
		store.add(new Interval(2, 81));
		for(Interval i : store)
			System.out.println(i);
	}
}


















