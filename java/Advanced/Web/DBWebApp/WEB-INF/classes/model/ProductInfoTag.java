package model;

import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.annotation.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ProductInfoTag extends SimpleTagSupport{

	@Resource(name="jdbc/SalesDB")
	private DataSource ds; //Dependency Context Injection(DCI)
						   //Initialized when this object is 
						   //activated by the container
	private String var;

	public void setVar(String name){
		var = name;
	}
	
	@Override
	public void doTag() throws IOException, JspException{
		JspContext context = super.getJspContext();
		JspFragment body = super.getJspBody();
		try{
			Connection con = ds.getConnection();
			try{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(
					"select pno,price,stock from products");
				while(rs.next()){
					context.setAttribute(var, new ProductInfo(rs));
					body.invoke(null);
				}
				rs.close();
				stmt.close();
			}finally{
				con.close();
			}
		}catch(Exception e){
			throw new JspTagException(e);
		}
	}
	
	public static class ProductInfo{
		
		private ResultSet rs;

		public ProductInfo(ResultSet rs){
			this.rs = rs;
		}

		public int getProductNo() throws SQLException{
			return rs.getInt("pno");
		}

		public double getPrice() throws SQLException{
			return rs.getDouble("price");
		}

		public int getStock() throws SQLException{
			return rs.getInt("stock");
		}
	}
}













