package com.amazon.classified.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.amazon.classified.db.ClassifiedDao;
import com.amazon.classified.db.UserDao;

//generates various reports from DB for admin user
public class ReportsController {

	public static void generateReports() {
		System.out.println("\n1.Users with classifieds posted\n");
		System.out.println("2.Group based on Payment methods\n");
		System.out.println("0.Goto Admin Menu\n");
		int choice = ScannerController.getScannerInstance().nextInt();

		switch (choice) {
		case 1:
			showUsersWithClassifieds();
			break;
		case 2:
			showUsersBasedOnPayment();
			break;
		default:
			System.err.println("Invalid choice");
			break;

		}

	}

	// shows users with atleast one classified posted
	private static void showUsersWithClassifieds() {
		printUsers(ClassifiedDao.showUsersWithClassifieds());
	}

	private static void showUsersBasedOnPayment() {
		System.out.println("\nSelect payment method\n");
		System.out.println("1.CC\n");
		System.out.println("2.UPI\n");
		String paymentMethod = "";
		int choice = ScannerController.getScannerInstance().nextInt();
		if (choice == 1) {
			paymentMethod = "CC";
		} else if (choice == 2) {
			paymentMethod = "UPI";
		}
		printUsers(UserDao.showUsersBasedOnPayment(paymentMethod));
	}

	//to print the classified data 
	private static void printUsers(ResultSet userSet) {
		int count = 1;
		System.out.println();
		try {
			while (userSet.next()) {
				System.out.print(count++ + ". ");
				System.out.println(userSet.getString("login")+"\n");
			}
		} catch (SQLException e) {
			System.out.println("\nSomething went wrong\n");
			e.printStackTrace();
		}
	}
}
