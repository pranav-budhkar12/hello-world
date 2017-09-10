class GenClassTest1{

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

	public static void main(String[] args){
		IndexedValue<Double> a = new IndexedValue<Double>();
		a.setValue(12.34);
		System.out.printf("IndexedValue:%d => %s%n",
			a.getIndex(), a.getValue());		
		IndexedValue<String> b = new IndexedValue<String>();
		b.setValue("monday");
		System.out.printf("IndexedValue:%d => %s%n",
			b.getIndex(), b.getValue());		
		IndexedValue<Interval> c = new IndexedValue<Interval>();
		c.setValue(new BigInterval(2, 30, 40));
		System.out.printf("IndexedValue:%d => %s%n",
			c.getIndex(), c.getValue());		
	}
}




















