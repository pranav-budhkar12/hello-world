class StaticProxyTest{

	static class EchoProxy{
		
		private static String format = ">> Invoking %s method of %s%n";

		public static Greeter createFor(final Greeter original){
			final Class<?> c = original.getClass();
			return new Greeter(){
				public String meet(String name, int age){
					System.out.printf(format, "meet", c);
					return original.meet(name, age);
				}

				public String leave(String name){
					System.out.printf(format, "leave", c);
					return original.leave(name);
				}
			};
		}
	}

	public static void main(String[] args) throws Exception{
		Greeter g = new EnglishGreeter();
		Greeter gp = EchoProxy.createFor(g);
		System.out.println(gp.meet("Jill", 34));
		System.out.println(gp.leave("Jack"));
	}
}















