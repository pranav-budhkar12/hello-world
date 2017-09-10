class InterfaceFieldsTest{

	interface RoomType{
		int ECONOMY = 1;
		int BUSINESS = 2;
		int EXECUTIVE = 3;
		int DELUXE = 4;
	}

	private static double getRent(int stay, int catagory){
		float rate;
		switch(catagory){
			case RoomType.ECONOMY:
				rate = 550;
				break;
			case RoomType.BUSINESS:
				rate = 750;
				break;
			case RoomType.EXECUTIVE:
				rate = 850;
				break;
			default:
				rate = 1050;
		}
		return 1.05 * stay * rate;
	}

	public static void main(String[] args){
		int days = args.length < 1 ? 5 : Integer.parseInt(args[0]);
		System.out.printf("Total rent for %d day/s%n", days);
		System.out.printf("Economy  \t%.2f%n", 
			getRent(days, RoomType.ECONOMY));
		System.out.printf("Business \t%.2f%n", 
			getRent(days, RoomType.BUSINESS));
		System.out.printf("Executive\t%.2f%n", 
			getRent(days, RoomType.EXECUTIVE));
		System.out.printf("Deluxe   \t%.2f%n", 
			getRent(days, 25));
	}
}





















