import java.sql.*;
import java.util.*;

class MySQLQueryTest{

	public static void main(String[] args) throws Exception{
		Driver d = new com.mysql.jdbc.Driver();
		Properties auth = new Properties();
		auth.setProperty("user", "root");
		Connection con = d.connect("jdbc:mysql://localhost/sales", auth);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(
			"select pno, price, stock from products");
		while(rs.next()){
			System.out.printf("%d\t%.2f\t%d%n",	rs.getInt(1),
				rs.getDouble(2), rs.getInt("stock"));
		}
		rs.close();
		stmt.close();
		con.close();
	}
}















