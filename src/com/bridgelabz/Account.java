package com.bridgelabz;

import java.util.Scanner;

public class Account {

	static double amount = 0;

	Scanner scan = new Scanner(System.in);

	// getter and setter for amount
	public static double getAmount() {
		return amount;
	}

	public static void setAmount(double amount) {
		Account.amount = amount;
	}

	public static void credit(double credit_value) {                              //method to credit account

		double temp_amount = Account.getAmount();                                 //assigning amount balance to temp
		temp_amount += credit_value;                                              // adding the temp amount with credit amount
		Account.setAmount(temp_amount);                                           // setting the amount with setters
		System.out.println(" Updated amount: " + Account.getAmount());            // displaying the amount with the help of getters 
	}

	public static boolean debit(double debit_value) {                             // method to debit account balance

		if (Account.getAmount() - debit_value < 0) {                              // if amount value - debit value is greater than alert user
			System.out.println(" Insufficient funds!");
			return false;
		}

		double temp_amount = Account.getAmount();                                 // assigning the account balance to temp
		temp_amount -= debit_value;                                               // debit the account 
		Account.setAmount(temp_amount);                                           // setting the amount

		return true;
	}

}