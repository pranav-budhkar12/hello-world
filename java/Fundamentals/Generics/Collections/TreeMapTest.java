import java.util.*;

class TreeMapTest{

	public static void main(String[] args){
		Map<String, Interval> store = new TreeMap<String, Interval>();
		store.put("monday", new Interval(3, 21));
		store.put("tuesday", new Interval(5, 12));
		store.put("wednesday", new Interval(7, 33));
		store.put("thursday", new Interval(6, 24));
		store.put("friday", new Interval(4, 35));
		store.put("monday", new Interval(2, 56));
		for(Map.Entry<String, Interval> e : store.entrySet())
			System.out.printf("%s => %s%n", e.getKey(), e.getValue());
		Scanner input = new Scanner(System.in);
		System.out.print("Key: ");
		String key = input.next();
		Interval val = store.get(key);
		if(val != null)
			System.out.printf("Value => %s%n", val);
		else
			System.out.println("ERROR: No such key!");
	}
}


















