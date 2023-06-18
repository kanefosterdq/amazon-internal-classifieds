package com.amazon.classified.model;

//admin user
public class Admin {
	
	private static Admin adminobj;
	private String adminID;
	private String adminPassword;

	public static Admin getAdminobjInstance() {
		if (adminobj == null) {
			adminobj = new Admin();

			// hard coded admin credentials
			adminobj.adminID = "admin";
			adminobj.adminPassword = "admin@123";
		}
		return adminobj;
	}

	public String getAdminID() {
		return adminID;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

}
