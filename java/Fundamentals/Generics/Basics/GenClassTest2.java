class GenClassTest2{

	static class IndexedValue<V>{
		
		private int index;
		private V value;
		private static int count;

		public IndexedValue(){
			index = ++count;
		}

		public int getIndex(){
			return index;
		}

		public V getValue(){
			return value;
		}

		public void setValue(V value){
			this.value = value;
		}
	}

	private static void print(IndexedValue<?> iv){
		System.out.printf("IndexedValue:%d => %s%n",
			iv.getIndex(), iv.getValue());
	}

	public static void main(String[] args){
		IndexedValue<Double> a = new IndexedValue<Double>();
		a.setValue(12.34);
		print(a);
		IndexedValue<String> b = new IndexedValue<String>();
		b.setValue("monday");
		print(b);
		IndexedValue<Interval> c = new IndexedValue<Interval>();
		c.setValue(new BigInterval(2, 30, 40));
		print(c);
	}
}




















