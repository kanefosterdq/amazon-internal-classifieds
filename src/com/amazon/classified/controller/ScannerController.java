package com.amazon.classified.controller;

import java.util.Scanner;

public class ScannerController {

	//singleton pattern - only one instance gets created for a user session
	public static Scanner scanner;
	public static Scanner getScannerInstance() {
		if(scanner == null) 
			scanner = new Scanner(System.in);
		return scanner;
	}
}
