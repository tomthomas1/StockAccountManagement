package com.bridgelabz;

import java.util.Scanner;

public class Account {
	static int amount = 0;

	Scanner scan = new Scanner(System.in);
	StockManager sp = new StockManager();            //creating object

	public static int getAmount() {
		return amount;
	}

	public static void setAmount(int amount) {
		Account.amount = amount;
	}

	public void credit() {                                                          // method to credit account
		System.out.print(" Please enter the amount to credit: ");
		double credit_value = scan.nextDouble();

		amount += credit_value;                                                      // add credit amount to account
		System.out.println(" The current balance is : " + amount);
	}

	public void debit() {                                                           // method to debit account
		System.out.print(" Please enter the amount to debit: ");
		double debit_value = scan.nextDouble();

		if (amount - debit_value < 0) {                                               // checking if the account balance is less than 0 after debit
			System.out.println(" Insufficient funds ");
			return;
		}

		amount -= debit_value;                                                       // debit the  amount from account
		System.out.println(" The current balance is : " + amount);

	}

	public void amountUpdate() {                                               // checking account balance
		System.out.println(" The Account balance is : " + amount);
	}
}