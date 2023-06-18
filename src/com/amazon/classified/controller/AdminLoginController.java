package com.amazon.classified.controller;
import com.amazon.classified.model.Admin;

//all the operations of admin starts here
public class AdminLoginController {

	//checks if given password and user matches
	public static boolean login() {
		System.out.println("\nAdmin ID  \n");
		ScannerController.getScannerInstance().nextLine();
		String id = ScannerController.getScannerInstance().nextLine();
		System.out.println("\nPassword  ");
		String password = ScannerController.getScannerInstance().nextLine();
		if ((Admin.getAdminobjInstance().getAdminID().equals(id))
				&& Admin.getAdminobjInstance().getAdminPassword().equals(password)) {
			System.out.println("\nWelcome Admin :)\n");
			return true;
		}

		return false;
	}

	//main menu for admin
	public static void showMenu() {
		boolean quit = false;
		while (!quit) {
			System.out.println("\nSelect operation\n");
			System.out.println("1.Approve / Reject classifieds\n");
			System.out.println("2.Activate / Deactivate users\n");
			System.out.println("3.Add / Remove classifieds\n");
			System.out.println("4.Manage categories of classifieds\n");
			System.out.println("5.Generate Reports\n");
			System.out.println("6.Quit Admin Menu\n");
			System.out.println("Your choice ");
			String choice = ScannerController.getScannerInstance().nextLine();

			switch (choice) {
			case "1":
				ClassifiedController.getClassifiedsForAdmin();
				ClassifiedController.approveOrRejectProduct();
				break;
			case "2":
				UserStatusController.updateStatus();
				break;
			case "3":
				AddRemoveClassifiedController.addRemoveClassified();
				break;
			case "4":
				ClassifiedController.updateClassifiedCategory();
				break;
			case "5":
				ReportsController.generateReports();
				break;
			case "6":
				quit = true;
				break;
			default:
				System.err.println("\nInvalid choice\n");
				break;
			}
			if (quit) {
				break;
			}
		}
	}

}
