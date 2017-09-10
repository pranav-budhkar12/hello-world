class TypesafeEnumTest{

	static enum RoomType{
		ECONOMY, BUSINESS, EXECUTIVE, DELUXE;
	}

	private static double getRent(int stay, RoomType catagory){
		float rate;
		switch(catagory){
			case ECONOMY:
				rate = 550;
				break;
			case BUSINESS:
				rate = 750;
				break;
			case EXECUTIVE:
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
			getRent(days, RoomType.DELUXE));
	}
}





















