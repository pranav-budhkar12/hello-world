import java.sql.*;

class StoredProcTest{

	public static void main(String[] args) throws Exception{
		String customerId = args[0].toUpperCase();
		int productNo = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		Date today = new Date(System.currentTimeMillis());
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@//localhost/xe", "scott", "tiger");
		try{
			CallableStatement cstmt = con.prepareCall(
				"{call PLACE_ORDER(?,?,?,?)}");
			cstmt.setString(1, customerId);
			cstmt.setInt(2, productNo);
			cstmt.setInt(3, quantity);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.executeUpdate();
			int orderNo = cstmt.getInt(4);
			cstmt.close();
			System.out.printf("New Order Number: %d%n", orderNo);
		}catch(SQLException e){
			System.out.printf("Order Failed: %s%n", e.getMessage());
		}
		con.close();
	}
}
























