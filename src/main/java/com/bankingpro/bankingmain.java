package com.bankingpro;

import java.util.*;

public class bankingmain {

	public static void main(String[] args) throws Exception {
		
		
		Scanner bs=new Scanner(System.in);
		bankingdao dao=new bankingdao();
		customer c1=new customer();

		System.out.println("\t\t\t********Welcome to Java Bank***********");
		System.out.println("Enter Customer Name");
		String cname=bs.nextLine();
		System.out.println("Enter Customer Id");
		int cid=bs.nextInt();
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

		//if insertion is success response is 1 otherwise 0
		if(res==1) {
			System.out.println("account creation successful");
		}
		else {
			System.out.println("Something went wrong");
		}
       
        bs.close();


	}

}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
