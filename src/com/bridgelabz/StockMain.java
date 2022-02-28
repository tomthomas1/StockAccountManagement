package com.bridgelabz;

import java.util.Scanner;

public class StockMain {

	// main function
	public static void main(String[] args) {
		System.out.println("----Welcome to stock account management program----");
		Scanner sc = new Scanner(System.in);
		StockManager func = new StockManager();                              //creating object
		while (true) {
			System.out.println(" \n Please enter your choice : " + "\n1. Buy Shares\n 2. Sell Shares\n "
					+ "3. Credit Account\n 4. Debit Account\n "
					+ "5. Print Account Balance\n 6. Print Portfolio Details\n 7. Exit");

			System.out.print(" Please enter your choice: ");
			int opt = sc.nextInt();
			int amount;
			String symbol;

			//calling functions with switch case
			switch (opt) {
			case 1:
				System.out.print(" Enter which stock you want to buy: ");
				symbol = sc.next();
				System.out.print(" Enter amount to be spent on shares: ");
				amount = sc.nextInt();
				func.buy(amount, symbol);
				break;

			case 2:
				System.out.print(" Enter which stock you want to sell: ");
				symbol = sc.next();
				System.out.print(" Enter value of shares to be sold: ");
				amount = sc.nextInt();
				func.sell(amount, symbol);
				break;
			case 3:
				System.out.println("Enter amount to deposit in account : ");
				amount = sc.nextInt();
				Account.credit(amount);
				break;
			case 4:
				System.out.println("Enter amount to withdraw from account : ");
				amount = sc.nextInt();
				Account.debit(amount);
				break;
			case 5:
				func.valueOf();
				break;
			case 6:
				func.printReport();
				break;
			case 7:
				System.out.println(" Exiting stock account management program");
				sc.close();
				return;
			default:
				System.out.println(" Please enter a valid choice");

			}
		}
	}
}