package com.amazon.classified.controller;

import com.amazon.classified.db.MessageDao;

public class MessageController {

	//send message to another user
	public static void sendMessage() {
		System.out.println("\nEnter owner's login");
		String receiver = ScannerController.getScannerInstance().nextLine();
		System.out.println("\nEnter your message");
		String sender = SessionController.user.getLogin();;
		String message = ScannerController.getScannerInstance().nextLine(); 
		MessageDao.addMessage(sender, receiver, message);
	}

	public static void viewMessages() {
		MessageDao.viewMessages(SessionController.user.getLogin());
	}

}
