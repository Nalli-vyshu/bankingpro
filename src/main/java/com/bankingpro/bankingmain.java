package com.bankingpro;

import java.util.*;

public class bankingmain {

	public static void main(String[] args) throws Exception {
		
		
		Scanner bs=new Scanner(System.in);
		bankingdao dao=new bankingdao();
		customer c1=new customer();

		System.out.println("\t\t\t********Welcome to Java Bank***********");
		System.out.println("Press 1 for Registration  \nPress 2 for login");
		int op=bs.nextInt();
		
		switch(op)  {
		
		case 1->{
			
			System.out.println("Enter Customer Id");
			int cid=bs.nextInt();
			bs.nextLine();
			System.out.println("Enter Customer Name");
			String cname=bs.nextLine();
			System.out.println("Enter Customer Pin");
			int cpin=bs.nextInt();
			System.out.println("Enter Customer Account balance");
			int cbal=bs.nextInt();
			
			
			c1.cusid=cid;
			c1.cusname=cname;
			c1.cuspin=cpin;
			c1.cusamount=cbal;
			
			//getting connection to db
			dao.dbconnection();
			//inserting user details into db
			int res=dao.registercustomer(c1);
			
			//if inserting is success responce is 1 otherwise
			if(res==1) {
				System.out.println("account creating successful");
			}
			else {
				System.out.println("Something went wrong");
			}
			
		}
		case 2-> {
			System.out.println("Welcome to login Page");
			System.out.println("Enter Username");
			bs.nextLine();
			String uname=bs.nextLine();
			System.out.println("Enter Password");
			int pwd=bs.nextInt();
			
			
			dao.dbconnection();
			
			int res=dao.login (uname,pwd);
			if(res==0)  {
				 System.out.println("username/password are incorrect");
			}
			else if(res==-1) {
				 System.out.println("Unable to find the details");
			}
			else {
				  System.out.println("Login successful");
				  System.out.println("Press 1 for Deposit\nPress 2 for Withdraw\nPress 3 for change password\nPress for delete acc");
				  int ops=bs.nextInt();
				  
				  switch(ops) {
				  case 1->{
				      System.out.println("Enter amount to deposit");
				      int amount=bs.nextInt();
				      int bal=dao.deposit(amount,res );
				      System.out.println("Deposit successful\n Avaliable Amount is :"+bal);
				  
				  }
				  case 2->{
					         System.out.println("Enter amount to withdraw");
					         int amount=bs.nextInt();
					         System.out.println("confirm your passworrd");
					         int confpwd=bs.nextInt();
					         int availamount=dao.withdraw(amount, confpwd, res);
					         if(availamount==-1) {
					        	   System.out.println("Low Balance");
					         }
					         else {
					        	  System.out.println("Withdraw successful \n Availabe Amount is :"+availamount);
					        	  
					         }
					         
					     }
				  case 4->{
					  
					       System.out.println("Enter password to delete");
					       int pass=bs.nextInt();
					       int status=dao.deleteAccount(pass, res);
					       if(status==1) {
					    	         System.out.println("Your account is deleted\n Good bye!....");
					       }
					       else {
					    	     System.out.println("Something went wrong");
					       }
					       
					       }
				  }
				  
				  
				  
				  }
				  
		}	  
				  
			     
		
		}
		
		
		
			
		bs.close();
	}

}





	


		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
