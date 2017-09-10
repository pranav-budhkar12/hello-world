import finance.*;
import java.lang.reflect.*;

class AnnotationTest2{

	public static void main(String[] args) throws Exception{
		double p = Double.parseDouble(args[0]);
		Class<?> c = Class.forName(args[1]);
		Object scheme = c.newInstance();
		Method meth = c.getMethod(args[2], double.class, int.class);
		MaxDuration md = meth.getAnnotation(MaxDuration.class);
		int l = md != null ? md.value() : 10;
		for(int n = 1; n <= l; ++n){
			float r = (Float) meth.invoke(scheme, p, n);
			double emi;
			emi = p * Math.pow(1 + r / 100, n) / (12 * n);
			System.out.printf("%d\t%.2f%n", n, emi);
		}
	}
}

























