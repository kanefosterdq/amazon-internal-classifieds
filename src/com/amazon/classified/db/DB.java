package com.amazon.classified.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	public static String URL = "jdbc:mysql://localhost/classifieds";
	public static String USER = "root";
	public static String PASSWORD = "root";
	Connection connection; // API from JDBC Package to store connection :)
	Statement statement; // API from JDBC Package to execute SQL Statements :)

	private static DB db = new DB();

	public static DB getInstance() {
		return db;
	}

	private DB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//System.out.println("[DB] Driver Loaded Successfully....");

			createConnection();

		} catch (Exception e) {
			System.err.println("Something Went Wrong: " + e);
		}

	}

	private void createConnection() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("[DB] Connection Created Successfully....");

	}

	public int executeSQL(String sql) {

		int result = 0;

		try {
			//System.out.println("[DB] Executing SQL Query | " + sql);
			statement = connection.createStatement();
			result = statement.executeUpdate(sql); // executeUpdate -> is used to perform insert/update/delete in table
			//System.out.println("[DB] SQL Query Executed...");
		} catch (Exception e) {
			System.err.println("Something Went Wrong: " + e);
		}

		return result;
	}

	public ResultSet executeQuery(String sql) {

		ResultSet set = null;

		try {
			//System.out.println("[DB] Executing SQL Query | " + sql);
			statement = connection.createStatement();
			set = statement.executeQuery(sql); // which will retrieve data from the table into java application
			//System.out.println("[DB] SQL Query Executed...");
		} catch (Exception e) {
			System.err.println("Something Went Wrong: " + e);
		}

		return set;
	}

	public void closeConnection() {
		try {
			connection.close();
			//System.out.println("[DB] Connection Closed...");
		} catch (Exception e) {
			System.err.println("Something Went Wrong: " + e);
		}
	}

}
