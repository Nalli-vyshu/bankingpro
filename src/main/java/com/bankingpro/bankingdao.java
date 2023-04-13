package com.bankingpro;
 import java.sql.*;

public class bankingdao {
	 
	Connection con=null;
	public void dbconnection() throws Exception {
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingpro","root","vyshu2525");

	}
	
	public  int registercustomer(customer c1) throws Exception {
		
		 String query="insert into customer values(?,?,?,?)";
		 PreparedStatement pst=con.prepareStatement(query);
		 pst.setInt (1, c1.cusid);
		 pst.setString(2, c1.cusname);
		 pst.setInt(3, c1.cuspin);
		 pst.setInt(4, c1.cusamount);
		 
		 
		 int res=pst.executeUpdate();
		 return res;
	}
	 public int login(String uname,int pwd) throws Exception {
		 
		 String query="select * from customer where cusname= '"+uname+"'";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(query);
		 
		 if(rs.next()) {
			  int password=rs.getInt(3);
			  if(password==pwd) {
				   return  rs.getInt(1);
			  }
			  else {
				   return 0;
			  }
		 }
		 else {
			 return -1;
			 
			  }
	 }
	 
	 public int  deposit(int amount,int customerid)throws Exception {
		 
		 String query2="select * from customer where cusid="+customerid;
		 
		 Statement st=con.createStatement();
		 
		 ResultSet rs=st.executeQuery(query2);
		 rs.next();
		 
		 int bal=rs.getInt(4);
		 
		 amount+=bal;
		 
		 String query="update customer set cusamount ="+amount+" where cusid="+customerid;
		 
		 PreparedStatement pst=con.prepareStatement(query);
		 
		 pst.executeUpdate();
		 
		    return amount;
		    
		 
		 
		 
		 
		 
	 }
	 }
	
	


