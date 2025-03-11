package com.bank.model;

import java.sql.Date;

public class BankCustomerDetails {
	private int id;
	private String name;
	private String emailid;
	private long mobilenumber;
	private long aadharnumber;
	private String pannumber;
	private int accountnumber;
	private int pin;
	private Date dateofbirth;
	private String address;
	private double amount;
	private int age;
	private String gender;
	private String status;
	
	public BankCustomerDetails()
	{
	}
		
		public BankCustomerDetails(int id, String name, String emailid, long mobilenumber, long aadharnumber,
	
			String pannumber, int accountnumber, int pin, Date dateofbirth, String address, double amount, int age,
			String gender) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.mobilenumber = mobilenumber;
		this.aadharnumber = aadharnumber;
		this.pannumber = pannumber;
		this.accountnumber = accountnumber;
		this.pin = pin;
		this.dateofbirth = dateofbirth;
		this.address = address;
		this.amount = amount;
		this.age = age;
		this.gender = gender;
		this.status=status;
	}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmailid() {
			return emailid;
		}

		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}

		public long getMobilenumber() {
			return mobilenumber;
		}

		public void setMobilenumber(long mobilenumber) {
			this.mobilenumber = mobilenumber;
		}

		public long getAadharnumber() {
			return aadharnumber;
		}

		public void setAadharnumber(long aadharnumber) {
			this.aadharnumber = aadharnumber;
		}

		public String getPannumber() {
			return pannumber;
		}

		public void setPannumber(String pannumber) {
			this.pannumber = pannumber;
		}

		public int getAccountnumber() {
			return accountnumber;
		}

		public void setAccountnumber(int accountnumber) {
			this.accountnumber = accountnumber;
		}

		public int getPin() {
			return pin;
		}

		public void setPin(int pin) {
			this.pin = pin;
		}

		public Date getDateofbirth() {
			return dateofbirth;
		}

		public void setDateofbirth(Date dateofbirth) {
			this.dateofbirth = dateofbirth;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "BankCustomerDetails [id=" + id + ", name=" + name + ", emailid=" + emailid + ", mobilenumber="
					+ mobilenumber + ", aadharnumber=" + aadharnumber + ", pannumber=" + pannumber + ", accountnumber="
					+ accountnumber + ", pin=" + pin + ", dateofbirth=" + dateofbirth + ", address=" + address
					+ ", amount=" + amount + ", age=" + age + ", gender=" + gender + ", status=" + status + "]";
		}

		
	
	
	

}
