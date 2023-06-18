package com.amazon.classified.controller;

import java.sql.SQLException;

import com.amazon.classified.db.UserDao;

//all the functionalities of normal user 
public class UserLoginController {

	//checks if login and password matches
	public static boolean login() throws SQLException {
		System.out.println("\nUser Name \n");
		ScannerController.getScannerInstance().nextLine();
		String id = ScannerController.getScannerInstance().nextLine();
		System.out.println("\nPassword \n");
		String password = ScannerController.getScannerInstance().nextLine();
		String passDB = "";
		passDB = UserDao.getUserPassword(id);
		String status = UserDao.getUserStatus(id);

		if (password.equals(passDB)) {
			SessionController.user.setLogin(id);
			if (status.equals("0")) {
				System.err.println("\nYour account is blocked! Please contact your Manager.\n");
				return false;
			}
			return true;
		}
		System.err.println("\nInvalid credentials\n");
		return false;
	}

	//main menu for normal user
	public static void showMenu() {

		System.out.println("\nWelcome user :)\n");
		boolean quit = false;
		while (!quit) {
			System.out.println("\nSelect operation\n");
			System.out.println("1.Manage your profile\n");
			System.out.println("2.Post a classified\n");
			System.out.println("3.View classifieds\n");
			System.out.println("4.Connect to an Employee for Buy or Sell\n");
			System.out.println("5.View your messages\n");
			System.out.println("6.Add payment method\n");
			System.out.println("7.Quit User Menu\n");

			String userChoice = ScannerController.getScannerInstance().nextLine();
			switch (userChoice) {
			case "1":
				UserUpdateController.getUserDetails();
				break;
			case "2":
				ClassifiedController.postNewClassifiedUser();
				break;
			case "3":
				ClassifiedController.getClassifiedsForUser();
				break;
			case "4":
				ClassifiedController.getClassifiedsForUser();
				MessageController.sendMessage();
				break;
			case "5":
				MessageController.viewMessages();
				break;
			case "6":
				PaymentIntegrationController.addPaymentMethod();
				break;
			case "7":
				quit = true;
				break;
			default:
				System.err.println("\nInvalid choice\n");
				break;
			}
			if (quit)
				break;
		}
	}
}
