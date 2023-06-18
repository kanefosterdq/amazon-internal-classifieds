package com.amazon.classified.controller;

import com.amazon.classified.db.PaymentDao;

public class PaymentIntegrationController {

	// user can choose a payment method and can add into DB
	public static void addPaymentMethod() {
		System.out.println("------------------");
		System.out.println("Accepted Payments");
		System.out.println("------------------");
		System.out.println("1.Credit card\n");
		System.out.println("2.UPI\n");
		System.out.println("\nYour choice");
		String choice = ScannerController.getScannerInstance().nextLine();
		if(choice.equals("1")) {
			System.out.println("\nEnter Your 16 digits card number");
			String card = ScannerController.getScannerInstance().nextLine();
			PaymentDao.addPaymentMethod(1,card); //1-type,details
		}else if(choice.equals("2")) {
			System.out.println("\nEnter your UPI ID (ex:abc@ybl)");
			String upiId = ScannerController.getScannerInstance().nextLine();
			PaymentDao.addPaymentMethod(2, upiId);
		}else {
			System.err.println("\nInvalid option");
		}
	}

}
