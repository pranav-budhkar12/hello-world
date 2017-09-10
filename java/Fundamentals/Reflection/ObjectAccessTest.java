import java.lang.reflect.*;

class ObjectAccessTest{
	
	private static void printAsXml(Object obj){
		Class<?> c = obj.getClass();
		System.out.printf("<%s>%n", c.getName());
		printFields(obj, c);
		System.out.printf("</%s>%n", c.getName());
	}

	private static void printFields(Object obj, Class<?> c){
		Class<?> sc = c.getSuperclass();
		if(sc != Object.class)
			printFields(obj, sc);
		Field[] fields = c.getDeclaredFields();
		for(Field f : fields){
			int m = f.getModifiers();
			if(Modifier.isStatic(m)) continue;
			System.out.printf("  <%s>", f.getName());
			try{
				f.setAccessible(true);
				System.out.print(f.get(obj));
			}catch(Exception e){
				System.out.print(e);
			}
			System.out.printf("</%s>%n", f.getName());
		}
	}

	public static void main(String[] args){
		printAsXml(new Interval(3, 45));
		printAsXml(new payroll.SalesPerson(186, 52, 60000));
	}
}























