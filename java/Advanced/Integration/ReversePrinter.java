public class ReversePrinter{

	public static int invoke(short op, String text){
		StringBuffer sb = new StringBuffer(text);
		sb.reverse();
		System.out.printf("OUTPUT: %s%n", sb);
		return sb.length();
	}
}

