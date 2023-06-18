package com.amazon.classified.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.amazon.classified.controller.ScannerController;
import com.amazon.classified.controller.SessionController;
import com.amazon.classified.model.Classified;

//every functions of classified where SQL operations needed
public class ClassifiedDao {


	//new product gets added to DB
	public static void addNewProduct(Classified product, int userType) {

		String category = "";
		if (product.getType() == 1) {
			category = "Speakers";
		} else if (product.getType()== 2) {
			category = "Books";
		} else if (product.getType()== 3) {
			category = "Mobile phones";
		} else if (product.getType()== 4) {
			category = "Computers";
		} else if (product.getType()== 5) {
			category = "iPods";
		}else {
			System.out.println("Please specify the category");
			ScannerController.getScannerInstance().nextLine();
			category = ScannerController.getScannerInstance().nextLine();
		}
		
		String addProductQuery = "";
		if (userType == 2) {
			addProductQuery = "insert into classified(name,description,price,type,status,login) " + "values('"
					+ product.getName() + "','" + product.getDesc() + "'," + product.getPrice() + ",'"
					+ category + "'," + product.getStatus() + ",'admin');";
		} else {
			addProductQuery = "insert into classified(name,description,price,type,status,login) " + "values('"
					+ product.getName() + "','" + product.getDesc() + "'," + product.getPrice() + ",'"
					+ category + "'," + product.getStatus() + ",'" + SessionController.user.getLogin() + "');";
		}
		System.out.println(" | " + addProductQuery);
		int result = DB.getInstance().executeSQL(addProductQuery);
		if (result > 0) {
			System.out.println("\n***** Product posted *****\n");
		} else {
			System.err.println("\nUnable to post a product!\n");
		}
	}

	//prints classieds for normal user
	public static void viewClassifiedsForUsers() {
		String fetchProductsQuery = "Select * from classified";
		ResultSet proSet = DB.getInstance().executeQuery(fetchProductsQuery);
		try {
			while (proSet.next()) {
				if (proSet.getString("status").equals("1")) {
					System.out.println();
					System.out.println("Product Id  : " + proSet.getString("productId"));
					System.out.println("Name        : " + proSet.getString("name"));
					System.out.println("Description : " + proSet.getString("description"));
					String category = proSet.getString("type");
					System.out.println("Category    : " + category);
					System.out.println("Price       : " + proSet.getString("price") + " Rs");
					System.out.println("PostedBy    : " + proSet.getString("login"));
					System.out
							.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
				}
			}
		} catch (SQLException e) {
			System.err.println("Something went wrong");
			e.printStackTrace();
		}

	}

	//prints classifieds for admin
	public static void viewClassifiedsForAdmin() {
		String fetchProductsQuery = "Select * from classified";
		ResultSet proSet = DB.getInstance().executeQuery(fetchProductsQuery);
		try {
			while (proSet.next()) {
				System.out.println();
				System.out.println("Product Id  : " + proSet.getString("productId"));
				System.out.println("Name        : " + proSet.getString("name"));
				System.out.println("Description : " + proSet.getString("description"));
				String status = proSet.getString("status");
				switch (status) {
				case "0":
					status = "REQUESTED";
					break;
				case "1":
					status = "APPROVED";
					break;
				case "2":
					status = "REJECTED";
				}
				System.out.println("Status      : " + status);
				String category = proSet.getString("type");
				System.out.println("Category    : " + category);
				System.out.println("Price       : " + proSet.getString("price") + " Rs");
				System.out.println("PostedBy    : " + proSet.getString("login"));
				System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");

			}
		} catch (SQLException e) {
			System.err.println("Something went wrong");
			e.printStackTrace();
		}

	}

	// Approve / Reject classified by Admin
	public static void updateClassifiedStatus(String pid, String newStatus) {
		String updateStatusQuery = "update classified set status = " + newStatus + " where productId = " + pid + ";";
		int result = DB.getInstance().executeSQL(updateStatusQuery);
		if (result > 0) {
			System.out.println("\nStatus updated\n");
		} else {
			System.err.println("\nSomething went wrong\n");
		}
	}

	public static void removeClassified(String pid) {
		String deleteProductQuery = "delete from classified where productId = " + pid + ";";
		int result = DB.getInstance().executeSQL(deleteProductQuery);
		if (result > 0) {
			System.out.println("\nClassified deleted.\n");
		} else {
			System.out.println("\nSomething went wrong\n");
		}

	}

	public static void updateClassifiedType(int pid, String category) {
		String updateTypeQuery = "update classified set type = '"+category+"' where productId = "+pid+";";
		int result = DB.getInstance().executeSQL(updateTypeQuery);
		if(result > 0) {
			System.out.println("\nClassified type updated\n");
		}else {
			System.err.println("\nUnable to update classified type!");
		}
	}

	//returns users who has posted atleast 1 classified
	public static ResultSet showUsersWithClassifieds() {
		String usersWithClassifiedsQuery = "Select distinct login  from classified";
		ResultSet userSet = DB.getInstance().executeQuery(usersWithClassifiedsQuery);
		return userSet;
		
	}

	
}
