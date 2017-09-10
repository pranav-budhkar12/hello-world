package model;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class CustomerBean implements java.io.Serializable{

	private String customerId;
	private DataSource ds;

	public CustomerBean(){
		try{
			Context naming = new InitialContext();
			ds = (DataSource) naming.lookup("jdbc/SalesDB");
		}catch(NamingException e){
			throw new RuntimeException(e);
		}
	}

	public final String getCustomerId(){
		return customerId;
	}

	public boolean authorize(String customerId, String password){
		try{
			Connection con = ds.getConnection();
			try{
				PreparedStatement pstmt = con.prepareStatement(
					"select count(cust_id) from customers where "
					+ "cust_id=? and pwd=?");
				pstmt.setString(1, customerId);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				int count = rs.next() ? rs.getInt(1) : 0;
				this.customerId = count == 1 ? customerId : null;
				rs.close();
				pstmt.close();
				return count == 1;
			}finally{
				con.close();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}































