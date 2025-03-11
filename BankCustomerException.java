package com.bank.exception;

public class BankCustomerException extends RuntimeException{
	private String exception;
	
	 public BankCustomerException() {
		}

	public BankCustomerException(String exception) {
		this.exception = exception;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
	
	

}
