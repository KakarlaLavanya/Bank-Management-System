package com.bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.BankCustomerDetails;

public class BankCustomerDAOImpl implements BankCustomerDAO {
	private static final String url="jdbc:mysql://localhost:3307/tecca_66_advance_java_project?user=root&password=root";
	private static final String insert_customer_details="insert into bank_customer_details(name,emailid,mobilenumber,aadharnumber,pannumber,"
			+ "dateOfbirth,address,amount,age,gender,status)values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String select="select * from bank_customer_details";

	private static final String update_pin_accountnumber="update bank_customer_details set accountnumber=?, pin=?,status=? where id=?";
	private static final String delete_customer_details="delete from bank_customer_details where id=?";
	private static final String customer_login="select * from bank_customer_details where emailid=? and pin=? ";
	private static final String update_amount="update bank_customer_details set amount=? where accountnumber=?";
	
	@Override
	public void insertBankCustomerDetails(BankCustomerDetails bankCustomerDetails)
	{
		try 
		{
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(insert_customer_details);
			preparedStatement.setString(1, bankCustomerDetails.getName());
			preparedStatement.setString(2, bankCustomerDetails.getEmailid());
			preparedStatement.setLong(3, bankCustomerDetails.getMobilenumber());
			preparedStatement.setLong(4, bankCustomerDetails.getAadharnumber());
			preparedStatement.setString(5, bankCustomerDetails.getPannumber());
			preparedStatement.setDate(6, bankCustomerDetails.getDateofbirth());
			preparedStatement.setString(7, bankCustomerDetails.getAddress());
			preparedStatement.setDouble(8, bankCustomerDetails.getAmount());
			preparedStatement.setInt(9, bankCustomerDetails.getAge());
			preparedStatement.setString(10,bankCustomerDetails.getGender());
			preparedStatement.setString(11, "Pending");
	
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				System.out.println("Customer registration successfull...");
			}
			else
			{
				System.out.println("Invalid data");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<BankCustomerDetails> getAllCustomerDetails(){
		try {
			
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(select);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<BankCustomerDetails> listOfBankCustomerDetails=new ArrayList<BankCustomerDetails>();
			if (resultSet.isBeforeFirst()) {
				
				while(resultSet.next()) {
					BankCustomerDetails bankCustomerDetails=new BankCustomerDetails();
					bankCustomerDetails.setId(resultSet.getInt("id"));
					bankCustomerDetails.setName(resultSet.getString("name"));
					bankCustomerDetails.setEmailid(resultSet.getString("emailid"));
					bankCustomerDetails.setMobilenumber(resultSet.getLong("mobilenumber"));
					bankCustomerDetails.setAadharnumber(resultSet.getLong("aadharnumber"));
					bankCustomerDetails.setPannumber(resultSet.getString("pannumber"));
					bankCustomerDetails.setStatus(resultSet.getString("status"));
					listOfBankCustomerDetails.add(bankCustomerDetails);
				}
				return listOfBankCustomerDetails;
				
			}
			else {
				return null;
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@Override
	public void updateaccountNumberAndPinByUsingId(BankCustomerDetails bankCustomerDetails) {
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(update_pin_accountnumber);
			preparedStatement.setInt(1, bankCustomerDetails.getAccountnumber());
			preparedStatement.setInt(2, bankCustomerDetails.getPin());
			preparedStatement.setString(3, "Accepted");
			preparedStatement.setInt(4, bankCustomerDetails.getId());
			
			int result=preparedStatement.executeUpdate();
			 if (result>0) {
				System.out.println("Updated");
			}
			 else {
				 System.out.println("Not Updated");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public BankCustomerDetails selectCustomerDetailsUsingEmailAndPin(String emailid, int pin) {
		BankCustomerDetails b=new BankCustomerDetails();
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(customer_login);
			preparedStatement.setString(1, emailid);
			preparedStatement.setInt(2, pin);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				b.setName(resultSet.getString("name"));
				b.setGender(resultSet.getString("gender"));
				b.setAmount(resultSet.getDouble("amount"));
				b.setAccountnumber(resultSet.getInt("accountnumber"));
				return b;
			}
			else {
				return b;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return b;
		}
		
	}
	@Override
	public void deleteCustomerDetailsByUsingId(BankCustomerDetails bankCustomerDetails) {
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(delete_customer_details);
			 preparedStatement.setInt(1, bankCustomerDetails.getId());
			 
			 int result=preparedStatement.executeUpdate();
			 if (result>0) {
				System.out.println("Deleted");
			}
			 else {
				 System.out.println("Not Deleted");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean updateBalanceAmountByUsingAccountNumber(double amount, int accountnumber) {
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(update_amount);
			preparedStatement.setDouble(1, amount);
			preparedStatement.setInt(2, accountnumber);
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
}
