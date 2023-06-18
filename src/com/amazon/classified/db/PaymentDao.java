package com.amazon.classified.db;

import com.amazon.classified.controller.SessionController;

//manages all payment related operations of users
public class PaymentDao {

	public static void addPaymentMethod(int type, String info) {
		String addPaymentQuery = "";
		if (type == 1) 
			addPaymentQuery = "insert into payment (login,payMethod,info)" + "values('"
					+ SessionController.user.getLogin() + "','CC','" + info + "');";
		if(type == 2)
			addPaymentQuery = "insert into payment (login,payMethod,info)" + "values('"
					+ SessionController.user.getLogin() + "','UPI','" + info + "');";
		int result = DB.getInstance().executeSQL(addPaymentQuery);
		if(result > 0) {
			System.out.println("\nPayment method added successfully.");
		}
		else {
			System.err.println("\nPayment method not added!");
		}
		
	}
}
