package com.bank.DAO;

import java.util.List;

import com.bank.model.TransactionDetails;

public interface TransactionDAO {
	public void insertTransactionDetails(TransactionDetails transactionDetails);
           List<TransactionDetails> getTransactionDetailsByUsingAccountNumber(int accountnumber);
}
