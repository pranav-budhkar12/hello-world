import java.sql.*;

class ParamSQLTest{

	public static void main(String[] args) throws Exception{
		String customerId = args[0].toUpperCase();
		int productNo = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		Date today = new Date(System.currentTimeMillis());
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@//localhost/xe", "scott", "tiger");
		con.setAutoCommit(false);
		try{
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update ord_ctl set ord_no=ord_no+1");
			ResultSet rs = stmt.executeQuery("select ord_no from ord_ctl");
			rs.next();
			int orderNo = rs.getInt(1);
			rs.close();
			stmt.close();
			PreparedStatement pstmt = con.prepareStatement(
				"insert into orders values(?,?,?,?,?)");
			pstmt.setInt(1, orderNo);
			pstmt.setDate(2, today);
			pstmt.setString(3, customerId);
			pstmt.setInt(4, productNo);
			pstmt.setInt(5, quantity);
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
			System.out.printf("New Order Number: %d%n", orderNo);
		}catch(SQLException e){
			con.rollback();
			System.out.printf("Order Failed: %s%n", e.getMessage());
		}
		con.close();
	}
}
























