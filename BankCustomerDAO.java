package com.bank.DAO;

import java.util.List;

import com.bank.model.BankCustomerDetails;

public interface BankCustomerDAO {

	 void insertBankCustomerDetails(BankCustomerDetails bankCustomerDetails);
	 void updateaccountNumberAndPinByUsingId(BankCustomerDetails bankCustomerDetails);
    List<BankCustomerDetails> getAllCustomerDetails();
    void deleteCustomerDetailsByUsingId(BankCustomerDetails bankCustomerDetails);
	 BankCustomerDetails selectCustomerDetailsUsingEmailAndPin(String emailid, int pin) ;
	 boolean updateBalanceAmountByUsingAccountNumber(double amount,int accountnumber);
		
}
