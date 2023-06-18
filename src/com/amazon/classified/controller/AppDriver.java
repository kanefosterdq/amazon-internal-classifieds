package com.amazon.classified.controller;

import java.sql.SQLException;

public class AppDriver {

	//main menu for login as normal user or admin
	public void initiate() {
		while (true) {
			
			System.out.println("\nSelect operation \n");
			System.out.println("1.User\n");
			System.out.println("2.Admin\n");
			System.out.println("0.Exit\n");
			System.out.println("Your choice\n");
			int userType = ScannerController.getScannerInstance().nextInt();
			boolean quit = false;
			switch (userType) {
			case 0:
				quit = true;
				break;
			case 1:
				try {
					if(UserLoginController.login()) {
						UserLoginController.showMenu();
					}
				} catch (SQLException e) {
					System.err.println("Something went wrong\n");
					e.printStackTrace();
				}
				
				break;
			case 2: 
				if(AdminLoginController.login()) {
					AdminLoginController.showMenu();
				}
				else {
					System.err.println("\nInvalid credentials\n");
				}
				break;

			default:
				System.err.println("\nInvalid choice\n");
				break;

			}
			
			//closing message
			if (quit) {
				System.out.println("\n*** Thank you for using Amazon Internal Classifieds ***\n");
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				break;
			}
		}

	}
}
