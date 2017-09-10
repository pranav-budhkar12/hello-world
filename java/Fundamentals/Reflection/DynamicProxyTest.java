import java.lang.reflect.*;

class DynamicProxyTest{

	static class EchoProxy{
		
		private static String format = ">> Invoking %s method of %s%n";

		public static Object createFor(final Object original){
			final Class<?> c = original.getClass();
			InvocationHandler ih = new InvocationHandler(){
				public Object invoke(Object proxy, Method method, 
				Object[] arguments) throws Exception{
					System.out.printf(format, method.getName(), c);
					return method.invoke(original, arguments);
				}
			};
			return Proxy.newProxyInstance(c.getClassLoader(), 
				c.getInterfaces(), ih);
		}
	}

	public static void main(String[] args) throws Exception{
		Greeter g = new EnglishGreeter();
		Greeter gp = (Greeter) EchoProxy.createFor(g);
		System.out.println(gp.meet("Jill", 34));
		System.out.println(gp.leave("Jack"));
	}
}















