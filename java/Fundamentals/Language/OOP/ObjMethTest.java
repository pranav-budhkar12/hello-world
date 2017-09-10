class ObjMethTest{

	public static void main(String[] args){
		Interval a = new Interval(3, 105);
		Interval b = new Interval(5, 20);
		Interval c = new Interval(4, 45);//a.add(b);
		Interval d = b;
		System.out.printf("a => %s%n", a);
		System.out.printf("b => %s%n", b);
		System.out.printf("c => %s%n", c);
		System.out.printf("d => %s%n", d);
		System.out.printf("a is identical to b: %b%n", a == b);
		System.out.printf("a is identical to c: %b%n", a == c);
		System.out.printf("b is identical to d: %b%n", b == d);
		System.out.printf("hash-code of a = %d%n", a.hashCode());
		System.out.printf("hash-code of b = %d%n", b.hashCode());
		System.out.printf("hash-code of c = %d%n", c.hashCode());
		System.out.printf("hash-code of d = %d%n", d.hashCode());
		System.out.printf("a is equal to b: %b%n", a.equals(b));
		System.out.printf("a is equal to c: %b%n", a.equals(c));
		System.out.printf("b is equal to d: %b%n", b.equals(d));
		a = b = c = null;
		System.gc();
	}

}














