package com.amazon.classified.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.amazon.classified.model.User;

//all user related Db operations
public class UserDao {

	//to fetch the user details from DB
	public static String getUserPassword(String login) {
		String credQuery = "select * from user where login = '"+login+"';";
		ResultSet userSet = DB.getInstance().executeQuery(credQuery);
		String password = "";
		try {
			while(userSet.next()) {
				password = userSet.getString("password");
			}
		} catch (SQLException e) {
			System.err.println("\nSomething went wrong\n");
			e.printStackTrace();
		}
		return password;
	}
	
	public static void updateUserDetails(User user) {
		String updateUserQuery = "update user set name = '"+user.getName()+"',"
				+ "phone = '"+user.getPhone()+"',location = '"+user.getLocation()+"',"
				+ "password = '"+user.getPassword()+"' where login = '"+user.getLogin()+"'";
		int result = DB.getInstance().executeSQL(updateUserQuery);
		if(result > 0) {
			System.out.println("\nDetails updated\n");
		}
	}

	public static void showUsers() {
		System.out.println("\n******************** USERS **************************\n");
		String fetchUserQuery = "select * from user";
		ResultSet userSet = DB.getInstance().executeQuery(fetchUserQuery);
		try {
			while(userSet.next()) {
				String status = userSet.getString("status");
				if(status.equals("0") ) {
					status = "DEACTIVATED";
				}else if(status.equals("1")){
					status = "ACTIVATED";
				}
				System.out.println("Login     : "+userSet.getString(1));
				System.out.println("Name      : "+userSet.getString(2));
				System.out.println("Location  : "+userSet.getString(4));
				System.out.println("Email     : "+userSet.getString(5));
				System.out.println("Phone     : "+userSet.getString(6));
				System.out.println("Status    : "+status);
				System.out.println();
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			}
		} catch (SQLException e) {
			System.err.println("\nSomething went wrong\n");
			e.printStackTrace();
		}
		
	}

	public static void updateUserStatus(String login, String newStatus) {
		String statusUpdateQuery = "update user set status = "+newStatus+" where login = '"+login+"';";
		int result = DB.getInstance().executeSQL(statusUpdateQuery);
		if(result > 0) {
			System.out.println("\nStatus updated\n");
		}
		else{
			System.err.println("\nSomething went wrong\n");
		}
		
	}

	//to check user status if their account is in activated status while login
	public static String getUserStatus(String id) {
		String fetchStatusQuery = "select status from user where login = '"+id+"';";
		ResultSet status = DB.getInstance().executeQuery(fetchStatusQuery);
		try {
			while(status.next()) {
				return status.getString(1);
			}
		} catch (SQLException e) {
			System.err.println("Something went wrong");
			e.printStackTrace();
		}
				
		return null;
	}
	
public static ResultSet showUsersBasedOnPayment(String paymentMethod) {
		String usersWithPaymentQuery = "select distinct login from payment where payMethod = '"+paymentMethod+"';";
		ResultSet userSet = DB.getInstance().executeQuery(usersWithPaymentQuery);
		return userSet;
		
	}
}
