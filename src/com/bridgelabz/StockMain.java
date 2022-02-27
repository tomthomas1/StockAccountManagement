package com.bridgelabz;

import java.util.Scanner;

public class StockMain {
	
	//main function
	public static void main(String[] args) {
		System.out.println("----Welcome to stock account management program----");
		Scanner sc = new Scanner(System.in);
		StockManager sm = new StockManager();                                                      //creating object of StockManager
		Account accountTest = new Account();

		while (true) {
			System.out.println(" \n Please enter your choice : " + "\n1.Add Stock" + "\n2.print stock report"
					+ "\n3.Credit amount"+"\n4.Debit amount"+ "\n5.Check Account Balance" +"\n6.Exit program");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				sm.addStock();
				break;
				
			case 2:
				sm.printStock();
				break;
				
			case 3:
				accountTest.credit();
				break;
				
			case 4:
				accountTest.debit();
				break;
				
			case 5:
				accountTest.amountUpdate();
				break;
				
			case 6:	
				System.out.println("Exited from stock account management program");
				sc.close();
				return;
				
			default :
				System.out.println("Enter valid choice between 1 to 3");
			}

		}
	}
}