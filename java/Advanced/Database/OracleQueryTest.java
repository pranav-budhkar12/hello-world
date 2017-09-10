import java.sql.*;
import java.util.*;

class OracleQueryTest{

	public static void main(String[] args) throws Exception{
		Driver d = new oracle.jdbc.OracleDriver();
		Properties auth = new Properties();
		auth.setProperty("user", "scott");
		auth.setProperty("password", "tiger");
		Connection con = d.connect(
			"jdbc:oracle:thin:@//localhost/xe", auth);
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















