package com.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bank.DAO.AdminDAO;
import com.bank.DAO.AdminDAOImpl;
import com.bank.DAO.BankCustomerDAO;
import com.bank.DAO.BankCustomerDAOImpl;
import com.bank.model.BankCustomerDetails;

public class AdminServiceImpl implements AdminService {
	Scanner scan=new Scanner(System.in);
	AdminDAO adminDAO=new AdminDAOImpl();
	BankCustomerDAO bankCustomerDAO=new BankCustomerDAOImpl();
	@Override
	public void adminLogin() {
		System.out.println("Enter Admin Emailid");
		String emailid=scan.next();
		System.out.println("Enter Admin Password");
		String password=scan.next();
		if(adminDAO.selectAdminDetailsByUsingEmailIdAndPassword(emailid, password)) {
			System.out.println("Enter \n  1.To Get All Account Request Details \n 2.To get all User Details "
					+ "\n 3.To get all Account closing Request Details");
			switch (scan.nextInt()) {
			case 1:
				System.out.println("All Account Request Details");
				allPendingDetails();
				break;
			case 2:
				System.out.println("All User Details");
				allUserDetails();
				break;
			case 3:
				System.out.println("All Account Closing Request Details");
				break;

			default:
				System.out.println("Invalid Request");
				break;
			}
			
		}
	}
	
	@Override
	public void allUserDetails() {
		/* Get the method from BankCustomerDAOImpl class */
		List<BankCustomerDetails> allCustomerDetails=bankCustomerDAO.getAllCustomerDetails();
		allCustomerDetails.forEach((customerdetails)->{
			System.out.println("Customer Name :"+customerdetails.getName());
			System.out.println("Customer Emailid :"+ customerdetails.getEmailid());
			System.out.println("Customer Mobile Number :"+customerdetails.getMobilenumber());
			System.out.println("******------******");
		});
	}

	@Override
	public void allPendingDetails() {
		List<BankCustomerDetails> allCustomerDetails=bankCustomerDAO.getAllCustomerDetails();
		List<BankCustomerDetails> allpendingdetailslist=new ArrayList<BankCustomerDetails>();
		for(BankCustomerDetails bankCustomerDetails:allCustomerDetails) {
			if(bankCustomerDetails.getStatus().equalsIgnoreCase("pending")) 
			{
				BankCustomerDetails bankCustomerDetails2=new BankCustomerDetails();
				bankCustomerDetails2.setId(bankCustomerDetails.getId());
				bankCustomerDetails2.setName(bankCustomerDetails.getName());
				bankCustomerDetails2.setEmailid(bankCustomerDetails.getEmailid());
				allpendingdetailslist.add(bankCustomerDetails2);
				int indexOf=allCustomerDetails.indexOf(bankCustomerDetails2)+1;
				System.out.println("S.No :"+indexOf);
				System.out.println("Customer Name :"+bankCustomerDetails.getName());
				System.out.println("Customer EmailId :"+bankCustomerDetails.getEmailid());
				System.out.println("Customer Mobile Number :"+bankCustomerDetails.getMobilenumber());
				System.out.println("Customer Status :"+bankCustomerDetails.getStatus());
			}
		}
		System.out.println("Enter S.No to select the customer details");
		BankCustomerDetails adminSelectedObject=allpendingdetailslist.get(scan.nextInt()-1);
		System.out.println(adminSelectedObject);
		//acceptPendingDetails(adminSelectedObject);
		System.out.println("Enter 1 to Accept \n 2 to Delete");
		switch (scan.nextInt()) {
		case 1:
			acceptPendingDetails(adminSelectedObject);
			break;
		case 2:
			bankCustomerDAO.deleteCustomerDetailsByUsingId(adminSelectedObject);
			break;

		case 3:
			break;
		}
		
	}

	@Override
	public void acceptPendingDetails(BankCustomerDetails bankCustomerDetails) {
		// TODO Auto-generated method stub
		Random random=new Random();
		int accountnumber=random.nextInt(10000000);
		System.out.println(accountnumber);
		if (accountnumber<10000000) {
			accountnumber+=1000000;
		}
		System.out.println(accountnumber);
		
		int pin=random.nextInt(10000);
		if (pin<1000) {
			pin+=1000;
		}
		bankCustomerDetails.setAccountnumber(accountnumber);
		bankCustomerDetails.setPin(pin);
		bankCustomerDAO.updateaccountNumberAndPinByUsingId(bankCustomerDetails);
	}

}
