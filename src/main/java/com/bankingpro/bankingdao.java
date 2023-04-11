package com.bankingpro;
 import java.sql.*;

public class bankingdao {
	 
	Connection con=null;
	public void dbconnection() throws Exception {
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingpro","root","vyshu2525");

	}
	
	public int registercustomer(customer c1) throws Exception {
		
		 String query="insert into customer values(?,?,?,?)";
		 PreparedStatement pst=con.prepareStatement(query);
		 pst.setInt (1, c1.cusid);
		 pst.setString(2, c1.cusname);
		 pst.setInt(3, c1.cuspin);
		 pst.setInt(4, c1.cusamount);
		 
		 
		 int res=pst.executeUpdate();
		 return res;
		
	}

}
