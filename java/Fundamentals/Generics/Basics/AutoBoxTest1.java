class AutoBoxTest1{

	public static void main(String[] args){
		double x = 12.25;
		Object y = x; // implicit boxing
		double z = (Double) y; // explicit unboxing
		System.out.printf("x = %s, y => %s, z = %s%n", x, y, z);
	}

}

