package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockManager implements StockAccountInterface {
	List<StockPortfolio> stocks = new ArrayList<StockPortfolio>();                         //creating array list of stock

	Scanner sc = new Scanner(System.in);

	public double valueOf() {                                                             // method to print the account balance

		System.out.println(" The current balance in account is: " + Account.getAmount()); // using getters to get balance
		return Account.getAmount();
	}

	public StockPortfolio findStock(String name) {                                         // function to get find stock as per the iser input

		for (StockPortfolio temp : stocks) {
			if (temp.getStockName().equals(name)) {                                        //equals method to check of the user stock matches list stock
				return temp;                                                               // if matches then return stock
			}
		}

		return null;
	}

	public StockPortfolio createStock(String name) {                                      //method to create Stock
		List<StockPortfolio> temp = stocks;

		System.out.print(" Enter the price per share: ");                                //taking input from user and setting it
		double price_of_share = sc.nextDouble();

		StockPortfolio stock = new StockPortfolio();
		stock.setStockName(name);
		stock.setQuantity(0);
		stock.setPerSharePrice(price_of_share);
		stocks.add(stock);                                                               // adding the stock to the list

		return stock;
	}

	public void buy(int amount, String symbol) {                                         //method to byt stock with parameter amount and stock name as symbol

		if (amount > Account.getAmount()) {                                              //if stock amount greater than account balance then alert user
			System.out.println(" Insufficient funds!");
			return;
		}

		StockPortfolio stock = findStock(symbol);                                       //taking the stock from list from the find stock

		if (stock == null) {                                                            //if findStock has returned null then the will call the create Stock method
			stock = createStock(symbol);
		}

		int quantity = (int) (amount / stock.getPerSharePrice());                      //the quantity will be amount / share price
		double debit_value = quantity * stock.getPerSharePrice();                      //then we debit the account with the value
		Account.debit(debit_value);
		stock.setQuantity(quantity + stock.getQuantity());                             //setting the quantity 
		stock.setTotalSharePrice(stock.getQuantity() * stock.getPerSharePrice());      // setting the total share

	}

	public void sell(int amount, String symbol) {                                    //method to sell stock

		StockPortfolio stock = findStock(symbol);

		if (stock == null) {                                                          //if findStock returns null then there is no stock as alert user
			System.out.println(" You do not possess this stock!");
			return;
		}

		int quantity = (int) (amount / stock.getPerSharePrice());                      //asking the user the quantity to share

		if (quantity > stock.getQuantity()) {                                          //if user enters more quantity then no action
			quantity = stock.getQuantity();
		}

		stock.setQuantity(stock.getQuantity() - quantity);                              //setting quantity as get quantity - quantity            

		double stock_value = stock.getQuantity() * stock.getPerSharePrice();            
		stock.setTotalSharePrice(stock_value);                                           // setting the total share price

		double credit_value = stock.getPerSharePrice() * quantity;
		Account.credit(credit_value);                                                    // crediting the account with the stock sold amount

	}

	public void printReport() {                                                       // method to print the stocks

		List<StockPortfolio> temp = stocks;
		int value = 0;

		for (StockPortfolio stock : temp) {
			System.out.println(stock);
			value += stock.getTotalSharePrice();
		}

		System.out.println(" Your entire portfolio is worth: " + value);

	}

}
