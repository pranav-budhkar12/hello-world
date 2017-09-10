import sales.client.*;

class FrontendTest{

	public static void main(String[] args) throws Exception{
		String customerId = args[0].toUpperCase();
		int productNo = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		try{
			OrderManagerService service = new OrderManagerService();
			OrderManager client = service.getOrderManagerPort();
			Invoice inv = client.placeOrder(
				customerId, productNo, quantity);
			System.out.printf("New order number is %d "
				+ "and payment is %.2f%n",
				inv.getOrderNo(), inv.getPayment());
		}catch(Exception e){
			System.out.printf("Order Failed: %s%n", e.getMessage());
		}
	}
}
























