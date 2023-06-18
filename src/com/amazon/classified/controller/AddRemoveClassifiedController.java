package com.amazon.classified.controller;

public class AddRemoveClassifiedController {

	// add/remove classified functionality for admin
	public static void addRemoveClassified() {
		System.out.println("\nSelect operation\n");
		System.out.println("1.Add Classified");
		System.out.println("2.Remove Classified");
		String choice = ScannerController.getScannerInstance().nextLine();
		switch(choice) {
		case "1":
			ClassifiedController.postNewClassifiedAdmin();
			break;
		case "2":
			ClassifiedController.removeClassified();
			break;
		default:
			System.err.println("\nInvalid choice\n");
			break;
		}
		
	}

}
