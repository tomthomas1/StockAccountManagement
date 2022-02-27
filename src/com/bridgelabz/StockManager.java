package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockManager {
	List<StockPortfolio> stocks = new ArrayList<StockPortfolio>();    //ArrayList for maintaining the stocks data
	double total_value = 0;

	public void addStock() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number of stocks to buy : ");
		int s = sc.nextInt();
		double value = 0;
		for (int i = 0; i < s; i++) {                                //loop to ask user to add number of stocks
			StockPortfolio stock = new StockPortfolio();             // creating the object of StockPortfolio
			System.out.println("Please enter the name of the script: ");                //taking input from user and using setters to set value
			stock.setStockName(sc.next());
			System.out.println("Please enter the total number of shares you want to buy: ");
			stock.setQuantity(sc.nextInt());
			System.out.println("Please enter the price per share: ");
			stock.setPerSharePrice(sc.nextDouble());

			value = stock.getQuantity() * stock.getPerSharePrice();              // calculating value as quantity * share price
			stock.setTotalSharePrice(value);                                     // setting the value with setters
			total_value += value;                                                // calculating the total value of total stocks
			stocks.add(stock);                                                   // adding the stock to array list
		}
	}

	public void printStock() {                                           
		// for printing the stocks report
		for (StockPortfolio stocks : stocks) {
			System.out.println(stocks);
		}
		System.out.println(" \n Total value of stock in your trading account is: " + total_value);     // printing the total value 

	}
}
