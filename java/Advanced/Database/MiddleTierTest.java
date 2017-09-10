import sales.*;
import javax.xml.ws.*;

class MiddleTierTest{

	public static void main(String[] args) throws Exception{
		OrderManager service = new OrderManager();
		Endpoint.publish("http://0.0.0.0:8056/orderManager", service);
	}
}

