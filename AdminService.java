package com.bank.service;

import com.bank.model.BankCustomerDetails;

public interface AdminService {
	 void adminLogin();
	 void allUserDetails();
	 void allPendingDetails();
	 void acceptPendingDetails(BankCustomerDetails bankCustomerDetails );

}
