Module Client

	Sub Main()

		Console.Write("Customer ID: ")
		Dim customerId As String = Console.ReadLine()
		Console.Write("Product No: ")
		Dim productNo As Integer = Console.ReadLine()
		Console.Write("Quantity: ")
		Dim quantity As Integer = Console.ReadLine()
		Dim client As New orderManagerClient
		Dim inv As invoice = client.placeOrder(customerId, productNo, quantity)
		Console.WriteLine("New order number is {0} and payment is {1:0.00}", inv.orderNo, inv.payment)

	End Sub

End Module
