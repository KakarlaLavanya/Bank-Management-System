package com.bank.DAO;

public interface AdminDAO {

	 boolean selectAdminDetailsByUsingEmailIdAndPassword(String emailid,String password);
}
