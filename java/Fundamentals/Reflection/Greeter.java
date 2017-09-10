interface Greeter{

	String meet(String name, int age);

	String leave(String name);

}

class EnglishGreeter implements Greeter{

	public String meet(String name, int age){
		if(age < 20)
			return "Hi " + name;
		return "Hello " + name;
	}

	public final String leave(String name){
		return "Goodbye " + name;
	}
}













