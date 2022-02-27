package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockManager {
	List<StockPortfolio> stocks = new ArrayList<StockPortfolio>();    //ArrayList for maintaining the stocks data
	StockPortfolio stock = new StockPortfolio(); 

	double total_value = 0;

	public void addStock() {
		if (StockPortfolio.getTotal_value() < Account.getAmount()||  Account.getAmount() > 1 ) {       // checking if the total balance is less than account balance
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number of stocks to buy : ");
		int s = sc.nextInt();
		double value = 0;
		for (int i = 0; i < s; i++) {                                //loop to ask user to add number of stocks
			StockPortfolio stock = new StockPortfolio();                 // creating the object of StockPortfolio
			System.out.println("Please enter the name of the script: ");                //taking input from user and using setters to set value
			stock.setStockName(sc.next());
			System.out.println("Please enter the total number of shares you want to buy: ");
			stock.setQuantity(sc.nextInt());
			System.out.println("Please enter the price per share: ");
			stock.setPerSharePrice(sc.nextDouble());

			value = stock.getQuantity() * stock.getPerSharePrice();                        //calculating value as quantity * share price
			if(value < Account.getAmount() ) {                                             // checking the condition if the stock value is less then account balance
			stock.setTotalSharePrice(value);                                               // setting the total share price as value
			Account.amount -= value;                                                       // debit the account with the stock value
			stocks.add(stock);                                                             // adding the stock to array list
			total_value += value;                                                          // adding the values
			StockPortfolio.setTotal_value(total_value);                                    // with the help of setters adding it to total value
			} else {
			 System.out.println("Sorry!! Insufficient balance to add stock");
			 break;
			}
		}
		}
	 else {
		System.out.println("Unable to add share due to insufficient balance in account. Please credit amount!!");         //if no sufficient balance then ask user to add balance
	}
	}

	public void printStock() {                                           
		// for printing the stocks report
		for (StockPortfolio stocks : stocks) {
			System.out.println(stocks);
		}
		System.out.println(" \n Total value of stock in your trading account is: " + StockPortfolio.getTotal_value());     // printing the total value 

	}
}

