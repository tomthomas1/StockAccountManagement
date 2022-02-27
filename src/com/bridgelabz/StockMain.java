package com.bridgelabz;

import java.util.Scanner;

public class StockMain {
	
	//main function
	public static void main(String[] args) {
		System.out.println("----Welcome to stock account management program----");
		Scanner sc = new Scanner(System.in);
		StockManager sm = new StockManager();                                                      //creating object of StockManager
		while (true) {                                                                              //will iterate till we close the scanner
			System.out.println(" \n Please enter your choice : " + "\n1.Add Stock" + "\n2.print stock report"
					+ "\n3.Exit program");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				//calling add stock method
				sm.addStock();
				break;

			case 2:
				// calling the print method
				sm.printStock();
				break;

			case 3:
				System.out.println("Exited from stock account management program");
				sc.close();   //to close the loop
				return;

			default:
				System.out.println("Enter valid choice between 1 to 3");
			}

		}

	}
}