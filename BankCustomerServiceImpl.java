package com.bank.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bank.DAO.BankCustomerDAO;
import com.bank.DAO.BankCustomerDAOImpl;
import com.bank.DAO.TransactionDAO;
import com.bank.DAO.TransactionDAOImpl;
import com.bank.exception.BankCustomerException;
import com.bank.model.BankCustomerDetails;
import com.bank.model.TransactionDetails;

public class BankCustomerServiceImpl implements BankCustomerService {
	Scanner scan=new Scanner(System.in);
	BankCustomerDAO bankCustomerDAO= new BankCustomerDAOImpl();
	List<BankCustomerDetails> allCustomerDetails=bankCustomerDAO.getAllCustomerDetails();
	BankCustomerDetails bankCustomerDetails=new BankCustomerDetails();
	private BankCustomerDetails loginPersonDetails;
	TransactionDAO transactionDAO=new TransactionDAOImpl();
	@Override
	public void bankCustomerDetails() {
		
		System.out.println("Enter Customer Name");
		String name=scan.next();
		bankCustomerDetails.setName(name);
		
		boolean emailStatus=true;
		while(emailStatus) {
		System.out.println("Enter customer EmailId:");
		String emailid=scan.next();
		
		int emailCount=0;
		try {
			for (BankCustomerDetails bankCustomerDetails2:allCustomerDetails) {
				if (bankCustomerDetails2.getEmailid().equals(emailid)) {
					emailCount++;
				}
			}
			if(emailCount>0) {
				//System.out.println("Already EmailId existed");
				throw new BankCustomerException("Already EmailId existed");
			}
			else {
				bankCustomerDetails.setEmailid(emailid);
				emailStatus=false;
			}
			
		}
		
		catch(BankCustomerException bankCustomerException) {
			System.out.println(bankCustomerException.getException());
		}
		}
		boolean mobilenostatus=true;
		System.out.println("Enter customer Mobile Number:");
		long mobilenumber=scan.nextLong();
		while(true)
    	{
    		
    		if(privoiusPresent(mobilenumber,1)>0)
    		{
	    		try {
	    		  throw new BankCustomerException("Already MobileNumber Existed");
	    		}
	    		catch(BankCustomerException bankCustomerException)
	    		{
	    			System.out.println(bankCustomerException.getException());
	    			System.out.println("Enter valid MobileNumber");
	    			mobilenumber=scan.nextLong();
	    			bankCustomerDetails.setMobilenumber(mobilenumber);
	    		}
    	  }
    		else
    		{
    			break;
    		}
    		
    	}
		bankCustomerDetails.setMobilenumber(mobilenumber);
		
		
		System.out.println("Enter customer Aadhar Number:");
		long aadharNo=scan.nextLong();
		while(true)
    	{
    		
    		if(privoiusPresent(aadharNo,2)>0)
    		{
	    		try {
	    		  throw new BankCustomerException("Already AadharNumber Existed");
	    		}
	    		catch(BankCustomerException bankCustomerException)
	    		{
	    			System.out.println(bankCustomerException.getException());
	    			System.out.println("Enter valid AadharNumber");
	    			aadharNo=scan.nextLong();
	    			bankCustomerDetails.setAadharnumber(aadharNo);
	    		}
    	  }
    		else
    		{
    			break;
    		}
    		
    	}
        bankCustomerDetails.setAadharnumber(aadharNo);
		
		System.out.println("Enter Customer PAN card (ABCDE1234Y):");
		String pannumber=scan.next();
		while(true)
    	{
    		
    		if(privoiusPresent(pannumber,2)>0)
    		{
	    		try {
	    		  throw new BankCustomerException("Already PanCard  Existed");
	    		}
	    		catch(BankCustomerException bankCustomerException)
	    		{
	    			System.out.println(bankCustomerException.getException());
	    			System.out.println("Enter valid  Pan Number");
	    			pannumber=scan.next();
	    			bankCustomerDetails.setPannumber(pannumber);
	    		}
    	  }
    		else
    		{
    			break;
    		}
    		
    	}
    	bankCustomerDetails.setPannumber(pannumber);
		
		System.out.println("Enter Customer DATE OF BIRTH (YYYY-MM-DD):");
		String dob=scan.next();
		bankCustomerDetails.setDateofbirth(Date.valueOf(dob));
		
		System.out.println("Enter Customer Address:");
		String address=scan.next();
		bankCustomerDetails.setAddress(address);
		
		System.out.println("Enter Customer Age:");
		int age=scan.nextInt();
		bankCustomerDetails.setAge(age);
		
		System.out.println("Enter Amount:");
		double amount=scan.nextDouble();
		bankCustomerDetails.setAmount(amount);
		
		System.out.println("Enter customer gender");
		String gender=scan.next();
		bankCustomerDetails.setGender(gender);
		
		bankCustomerDAO.insertBankCustomerDetails(bankCustomerDetails);
		
	}
	 public int privoiusPresent(long number,int n)
	    {
	    	    int count=0;
	    		for (BankCustomerDetails bankCustomerDetails2 : allCustomerDetails)
	        	{
	        			if(n==1)
	        			{
	        				if(bankCustomerDetails2.getMobilenumber()==number)
	            			{
	            				count++;
	            			}
	        			}
	        			else
	        			{
	        				if(bankCustomerDetails2.getAadharnumber()==number)
	            			{
	            				count++;
	            			}
	        			}
	        	}
	    		return count;
	    	}
	 public int privoiusPresent(String name,int n)
	    {
	    	int count=0;
	    	for (BankCustomerDetails bankCustomerDetails2 : allCustomerDetails)
	    	{
				if (n==1)
				{
					if(bankCustomerDetails2.getEmailid().equalsIgnoreCase(name))
					{
						count++;
					}
				}
				else
				{
					if(bankCustomerDetails2.getPannumber().equalsIgnoreCase(name)) {
						count++;
					}
				}
			}
			return count;
	    	
	    }

	@Override
	public void customerLogin() {
		// TODO Auto-generated method stub
		System.out.println("Enter Customer Emailid");
		String emailid=scan.next();
		System.out.println("Enter Customer Pin");
		int pin=scan.nextInt();
	    
		if (bankCustomerDAO.selectCustomerDetailsUsingEmailAndPin(emailid,pin)!=null) {
			boolean status=true;
			while(status)
			{
				Random random=new Random();
				String capt="";
				String a[]= { "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c"
,"d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9"};
				for(int i=0;i<6;i++)
				{
					int index=random.nextInt(a.length);
					String cap=a[index];
					
					capt=capt+cap;
				}
				System.out.println("Your Capcha:"+capt);
				System.out.println("Enter Capcha");
				String usercapcha=scan.next();
				loginPersonDetails=bankCustomerDAO.selectCustomerDetailsUsingEmailAndPin(emailid, pin);
				if(capt.equals(usercapcha))
				{
					if(loginPersonDetails.getName()!=null)
					{
						if(loginPersonDetails.getGender().equalsIgnoreCase("Male"))
						{
							System.out.println("Hello Mr:"+loginPersonDetails.getName());
							bankCustomerOperations();
						}
						else
						{
							System.out.println("Hello Mrs:"+loginPersonDetails.getName());
							bankCustomerOperations();
						}
						
					}
					
					status=false;
					System.out.println("Login Successfull....");
				}
				else
				{
			       System.out.println("Invalid Capcha");
				}
			}
				
		}
		
		else
		{
			System.out.println("Invalid Emailid or Pin");
		}
		
	}
	
	@Override
	public void bankCustomerOperations() {
		System.out.println("Enter \n 1.For Credit \n 2.For Debit \n 3.For Check Balance \n 4.For Check Statement \n 5.Update Password \n 6.For Mobile To Mobile Transaction");
		switch(scan.nextInt())
		{
		case 1:
			System.out.println("credit");
			
			break;
		case 2:
			System.out.println("debit");
			debit();
			break;
		case 3:
			System.out.println("check balance");
			break;
		case 4:
			System.out.println("check statement");
			int accountnumber=loginPersonDetails.getAccountnumber();
			List<TransactionDetails> detailsByUsingAccountNumber=transactionDAO.getTransactionDetailsByUsingAccountNumber(accountnumber);
			if(!detailsByUsingAccountNumber.isEmpty()) {
				System.out.println("Name :"+loginPersonDetails.getName());
				System.out.println("Account Number :"+accountnumber);
				
				detailsByUsingAccountNumber.forEach((transactiondetails) ->{
					//System.out.println("Transaction id :"+transactiondetails.getTransactionid());
					System.out.println("Transaction Type :"+ transactiondetails.getTransactiontype());
					System.out.println("Transaction Date :"+ transactiondetails.getTransactiondate());
					System.out.println("Transaction Time :"+ transactiondetails.getTransactiontime());
					System.out.println("Transaction Amount :"+ transactiondetails.getTransactionamount());
					System.out.println("Balance Amount :"+transactiondetails.getBalanceamount());
					System.out.println("****----****----****----****");
				});
			} else {
				System.out.println("No transaction Details found");
				
			}
			break;
		case 5:
			System.out.println("update password");
			break;
		case 6:
			System.out.println("mobile to mobile transaction");
			break;
		default:
			System.out.println("Invalid Request.....");
			break;
	}
	}


	@Override
	public void debit() {
		System.out.println("Enter Amount");
		double userAmount=scan.nextDouble();
		if(userAmount>=0)
		{
			double databaseAmount=loginPersonDetails.getAmount();
			if(userAmount<=databaseAmount)
			{
				double balanceAmount=databaseAmount-userAmount;
				System.out.println(balanceAmount);
				int accountNum=loginPersonDetails.getAccountnumber();
				if(bankCustomerDAO.updateBalanceAmountByUsingAccountNumber(balanceAmount,accountNum))
				{
					TransactionDetails transactionDetails=new TransactionDetails();
					transactionDetails.setTransactiontype("Debit");
					transactionDetails.setTransactiondate(LocalDate.now());
					transactionDetails.setTransactiontime(LocalTime.now());
					transactionDetails.setAccountnumber(accountNum);
					transactionDetails.setBalanceamount(balanceAmount);
					transactionDetails.setTransactionamount(userAmount);
					transactionDAO.insertTransactionDetails(transactionDetails);
					System.out.println("Amount Debited...");
				}
				else {
					System.out.println("Server 404");
				}
				
			}
			else
			{
				System.out.println("Insufficient Balance😞😞");
			}
		}
		else
		{
			System.out.println("Invalid Enterd Amount");
		}
		

		
	}
	}
