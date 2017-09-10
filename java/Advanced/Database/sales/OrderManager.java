package sales;

import java.sql.*;
import javax.jws.*;

@WebService(targetNamespace="http://adsd.met.edu/sales")
public class OrderManager{
	
	@WebMethod
	public Invoice placeOrder(String customerId, int productNo, 
	int quantity){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost/xe",
				"scott", "tiger");
			con.setAutoCommit(false);
			try{
				Invoice result = new Invoice();
				Date today = new Date(System.currentTimeMillis());
				Statement stmt = con.createStatement();
				stmt.executeUpdate(
					"update ord_ctl set ord_no=ord_no+1");
				ResultSet rs = stmt.executeQuery(
					"select ord_no from ord_ctl");
				rs.next();
				result.orderNo = rs.getInt(1);
				rs.close();
				stmt.close();
				PreparedStatement pstmt = con.prepareStatement(
					"insert into orders values(?,?,?,?,?)");
				pstmt.setInt(1, result.orderNo);
				pstmt.setDate(2, today);
				pstmt.setString(3, customerId);
				pstmt.setInt(4, productNo);
				pstmt.setInt(5, quantity);
				pstmt.executeUpdate();
				pstmt = con.prepareStatement(
					"select ?*price from products where pno=?");
				pstmt.setInt(1, quantity);
				pstmt.setInt(2, productNo);
				rs = pstmt.executeQuery();
				rs.next();
				result.payment = 1.05 * rs.getDouble(1);
				rs.close();
				pstmt.close();
				con.commit();
				return result;
			}catch(SQLException e){
				con.rollback();
				throw e;
			}finally{
				con.close();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}















