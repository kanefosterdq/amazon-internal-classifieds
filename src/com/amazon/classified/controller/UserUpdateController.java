package com.amazon.classified.controller;

import com.amazon.classified.db.UserDao;
import com.amazon.classified.model.User;

public class UserUpdateController {
	
	//update everything except login ID and email as user has logged in 
	public static void getUserDetails() {
		User user = new User();
		user.setLogin(SessionController.user.getLogin());
		System.out.println("Please update your account details");
		System.out.println("Name ");
		String name = ScannerController.getScannerInstance().nextLine();
		System.out.println("New password ");
		String pass = ScannerController.getScannerInstance().nextLine();
		System.out.println("Location ");
		String location  = ScannerController.getScannerInstance().nextLine();
		System.out.println("Phone ");
		String phone = ScannerController.getScannerInstance().nextLine();
		user.setName(name);
		user.setPassword(pass);
		
		//as its amazon internal software
		user.setEmail(name+"@amazon.com");
		
		user.setLocation(location);
		user.setPhone(phone);
		UserDao.updateUserDetails(user);
	}
}
