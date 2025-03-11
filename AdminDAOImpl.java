package com.bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO {
	
	   private static final String admin_login="select * from admin_details where Email_id=? and Password=?";
		private static final String url="jdbc:mysql://localhost:3307/tecca_66_advance_java_project?user=root&password=root";
		@Override
		public boolean selectAdminDetailsByUsingEmailIdAndPassword(String emailid,String password) {
			try {
				Connection connection=DriverManager.getConnection(url);
				PreparedStatement preparedStatement=connection.prepareStatement(admin_login);
				preparedStatement.setString(1,emailid);
				preparedStatement.setString(2, password);
				ResultSet resultSet=preparedStatement.executeQuery();
				if (resultSet.next()) {
					//System.out.println("Login Succesfull......");
					return true;
					}
				else {
					//System.out.println("Invalid Emailid Or Password");
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

}
