package com.bank.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.TransactionDetails;

public class TransactionDAOImpl implements TransactionDAO {
	private static final String url="jdbc:mysql://localhost:3307/tecca_66_advance_java_project?user=root&password=root";
	private static final String insert_transaction_details="insert into transaction_details(Transaction_type, Transaction_date, Transaction_time, "
			                                        + " Balance_amount, Transaction_amount, Account_number)values (?,?,?,?,?,?)";
	private static final String get_transaction_details="select * from transaction_details where accountnumber=?";
	@Override
	public void insertTransactionDetails(TransactionDetails transactionDetails) {
		// TODO Auto-generated method stub
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(insert_transaction_details);
			preparedStatement.setString(1, transactionDetails.getTransactiontype());
			preparedStatement.setDate(2, Date.valueOf(transactionDetails.getTransactiondate()));
			preparedStatement.setTime(3, Time.valueOf(transactionDetails.getTransactiontime()));
			preparedStatement.setDouble(4, transactionDetails.getBalanceamount());
			preparedStatement.setDouble(5, transactionDetails.getTransactionamount());
			preparedStatement.setInt(6, transactionDetails.getAccountnumber());
			
		int result=	preparedStatement.executeUpdate();
		if (result>0) {
			System.out.println(transactionDetails);
		}
		else {
			System.out.println("Not Inserted");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<TransactionDetails> getTransactionDetailsByUsingAccountNumber(int accountnumber) {
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(get_transaction_details);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<TransactionDetails> listoftransactiondetails = new ArrayList<TransactionDetails>();
		    if (resultSet.isBeforeFirst()) {
		    	while (resultSet.next()) {
		    TransactionDetails transactionDetails=new TransactionDetails(resultSet.getInt("Transaction_id"),resultSet.getString("Transaction_type"),
							LocalDate.parse((CharSequence) resultSet.getDate("Transaction_date")),
							LocalTime.parse((CharSequence) resultSet.getTime("Transaction_time")),
							resultSet.getDouble(" Balance_amount"),
							resultSet.getDouble("Transaction_amount"),resultSet.getInt("Account_number"));
					  listoftransactiondetails.add(transactionDetails);
				}
		    	return listoftransactiondetails;
		}
		else {
			System.out.println("Not Inserted");
			return null;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
	}

}
