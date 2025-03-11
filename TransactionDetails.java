package com.bank.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionDetails {
	
	private int transactionid;
	private String transactiontype;
	private LocalDate transactiondate;
	private LocalTime transactiontime;
	private double balanceamount;
	private double transactionamount;
	private int accountnumber;
	
	public TransactionDetails() {
		
	}

	public TransactionDetails(int transactionid, String transactiontype, LocalDate transactiondate,
			LocalTime transactiontime, double balanceamount, double transactionamount, int accountnumber) {
		super();
		this.transactionid = transactionid;
		this.transactiontype = transactiontype;
		this.transactiondate = transactiondate;
		this.transactiontime = transactiontime;
		this.balanceamount = balanceamount;
		this.transactionamount = transactionamount;
		this.accountnumber = accountnumber;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public LocalDate getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(LocalDate transactiondate) {
		this.transactiondate = transactiondate;
	}

	public LocalTime getTransactiontime() {
		return transactiontime;
	}

	public void setTransactiontime(LocalTime transactiontime) {
		this.transactiontime = transactiontime;
	}

	public double getBalanceamount() {
		return balanceamount;
	}

	public void setBalanceamount(double balanceamount) {
		this.balanceamount = balanceamount;
	}

	public double getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transactionid=" + transactionid + ", transactiontype=" + transactiontype
				+ ", transactiondate=" + transactiondate + ", transactiontime=" + transactiontime + ", balanceamount="
				+ balanceamount + ", transactionamount=" + transactionamount + ", accountnumber=" + accountnumber + "]";
	}
	
	
	
	

}
