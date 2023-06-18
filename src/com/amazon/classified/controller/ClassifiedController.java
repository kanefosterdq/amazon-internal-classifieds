package com.amazon.classified.controller;

import com.amazon.classified.db.ClassifiedDao;
import com.amazon.classified.model.Classified;

//all operations where classified involves
public class ClassifiedController {

	//create a classified and sends the object to DB
	public static Classified createClassified() {
		Classified product = new Classified();
		System.out.println("\nProduct name \n");
		product.setName(ScannerController.getScannerInstance().nextLine());
		System.out.println("\nDescription(100 charatcters) \n");
		product.setDesc(ScannerController.getScannerInstance().nextLine());
		System.out.println("\nPrice \n");
		product.setPrice(ScannerController.getScannerInstance().nextInt());
		System.out.println("Select category \n");
		System.out.println("1-Speakers\n");
		System.out.println("2-Books\n");
		System.out.println("3-Mobile phones\n");
		System.out.println("4-Computers\n");
		System.out.println("5-iPods\n");
		System.out.println("6-Others\n");
		product.setType(ScannerController.getScannerInstance().nextInt());
		return product;

	}

	public static void postNewClassifiedUser() {
		Classified product = createClassified();
		product.setStatus(0);
		ClassifiedDao.addNewProduct(product, 1);
	}

	public static void postNewClassifiedAdmin() {
		Classified product = createClassified();
		product.setStatus(1);
		ClassifiedDao.addNewProduct(product, 2);
	}

	// inteface between DAO and Usercontroller
	public static void getClassifiedsForUser() {
		System.out.println("******** Products available **********");
		ClassifiedDao.viewClassifiedsForUsers();

	}

	public static void getClassifiedsForAdmin() {
		System.out.println("******** Products available **********");
		ClassifiedDao.viewClassifiedsForAdmin();
	}

	public static void removeClassified() {
		getClassifiedsForAdmin();
		System.out.println("\nEnter Product ID");
		String pid = ScannerController.getScannerInstance().nextLine();
		ClassifiedDao.removeClassified(pid);
	}

	//approve / reject a product for admin
	public static void approveOrRejectProduct() {
		System.out.println("Enter the Product ID");
		String pid = ScannerController.getScannerInstance().nextLine();
		System.out.println("1.Approve classified\n");
		System.out.println("2.Reject classified\n");
		System.out.println("Your choice ");
		String newStatus = ScannerController.getScannerInstance().nextLine();
		ClassifiedDao.updateClassifiedStatus(pid, newStatus);
	}

	//to print classified 
	public static void showCategories() {
		System.out.println("Select category \n");
		System.out.println("1-Speakers\n");
		System.out.println("2-Books\n");
		System.out.println("3-Mobile phones\n");
		System.out.println("4-Computers\n");
		System.out.println("5-iPods\n");
		System.out.println("6-Others\n");
		return;
	}

	public static String selectCategory() {
		String category = "";
		int choice = ScannerController.getScannerInstance().nextInt();
		if (choice == 1) {
			category = "Speakers";
		} else if (choice == 2) {
			category = "Books";
		} else if (choice == 3) {
			category = "Mobile phones";
		} else if (choice == 4) {
			category = "Computers";
		} else if (choice == 5) {
			category = "iPods";
		} else {
			System.out.println("Please specify the category");
			ScannerController.getScannerInstance().nextLine();
			category = ScannerController.getScannerInstance().nextLine();
		}
		return category;
	}

	//manage classified category
	public static void updateClassifiedCategory() {
		getClassifiedsForAdmin();
		boolean quit = false;
		while (!quit) {
			System.out.println("Enter Product ID");
			int pid = ScannerController.getScannerInstance().nextInt();
			System.out.println("\nUpdate the category to ?");
			ScannerController.getScannerInstance().nextLine();
			String category = ScannerController.getScannerInstance().nextLine();
			ClassifiedDao.updateClassifiedType(pid, category);
			System.out.println("\nWould you like to update any other product's category");
			System.out.println("1.Yes\n");
			System.out.println("2.No\n");
			int quitChoice = ScannerController.getScannerInstance().nextInt();
			if (quitChoice == 1) {
				quit = true;
			}
		}

	}
}
