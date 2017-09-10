import java.util.*;

class PropertiesTest{

	public static void main(String[] args){
		if(args.length > 0)
			System.out.printf("%s = %s%n", args[0], 
				System.getProperty(args[0]));
		else{
			Properties env = System.getProperties();
			env.list(System.out);
		}
	}
}


















