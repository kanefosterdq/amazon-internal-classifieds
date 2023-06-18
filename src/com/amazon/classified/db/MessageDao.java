package com.amazon.classified.db;

import java.sql.ResultSet;
import java.sql.SQLException;

// manages DB operations for messages between users
public class MessageDao {

	
	public static void addMessage(String sender, String receiver, String message) {
		String addMessageQuery = "insert into message (sender, mess,receiver)"
				+"values ('"+sender+"','"+message+"','"+receiver+"');";
		int result = DB.getInstance().executeSQL(addMessageQuery);
		if(result > 0) {
			System.out.println("\nMessage sent.\n");
		}else {
			System.err.println("\nMessage not sent!\n");
		}
	}
	
	public static void viewMessages(String login) {
		String fetchMessageQuery = "select * from message where receiver = '"+login+"';";
		ResultSet messageSet = DB.getInstance().executeQuery(fetchMessageQuery);
		try {
			System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
			while(messageSet.next()) {
				System.out.println("\nLogin : "+messageSet.getString("sender"));
				System.out.println("\n"+messageSet.getString("mess"));
				System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
			}
		} catch (SQLException e) {
			System.err.println("Something went wrong");
			e.printStackTrace();
		}
	}
}
