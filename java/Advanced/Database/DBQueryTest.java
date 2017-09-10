import java.io.*;
import java.sql.*;
import java.util.*;

class DBQueryTest{

	public static void main(String[] args) throws Exception{
		FileInputStream fin = new FileInputStream("jdbc.properties");
		Properties info = new Properties();
		info.load(fin);
		fin.close();
		Class.forName(info.getProperty("driver.class"));
		Connection con = DriverManager.getConnection(
			info.getProperty("driver.url"),
			info.getProperty("user.name"),
			info.getProperty("user.password"));
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















