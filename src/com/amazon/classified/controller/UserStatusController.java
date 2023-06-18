package com.amazon.classified.controller;

import com.amazon.classified.db.UserDao;

public class UserStatusController {

	//to activate or deactivate the normal user  -  only for admin
	public static void updateStatus() {
		UserDao.showUsers();
		System.out.println("Enter User Login ");
		String login = ScannerController.getScannerInstance().nextLine();
		System.out.println("\nSet status ");
		System.out.println("0.Deactivate");
		System.out.println("1.Activate");
		String newStatus = ScannerController.getScannerInstance().nextLine();
		UserDao.updateUserStatus(login,newStatus);
	}

}
