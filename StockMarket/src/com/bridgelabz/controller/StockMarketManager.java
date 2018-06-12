/**
 * 
 */
package com.bridgelabz.controller;
import com.bridgelabz.serviceImplementation.CustomerServiceImplementation;
import com.bridgelabz.serviceImplementation.StockServiceImplementation;
import com.bridgelabz.serviceImplementation.TransactionServiceImplementation;
import com.bridgelabz.utility.Utility;

public class StockMarketManager 
{
	public static final String STOCK_FILE="/home/adminstrato/BijayaWorkSpace/StockMarket/src/com/bridgelabz/files/Stock.json";
	public static final String CUSTOMER_FILE="/home/adminstrato/BijayaWorkSpace/StockMarket/src/com/bridgelabz/files/Customer.json";
	public static final String TRANSACTION_FILE="/home/adminstrato/BijayaWorkSpace/StockMarket/src/com/bridgelabz/files/Transaction.json";
	TransactionServiceImplementation transactionServiceImplementation=new TransactionServiceImplementation(TRANSACTION_FILE);
	StockServiceImplementation stockServiceImplementation=new StockServiceImplementation(STOCK_FILE);
	CustomerServiceImplementation customerServiceImplementation=new CustomerServiceImplementation(CUSTOMER_FILE);

	public static void main(String[] args)
	{
		showOptions();
	}

	private static void showOptions()
	{
		System.out.println("select one option");
		System.out.println("1. add a Stock \t\t 2. remove a Stock");
		System.out.println("3. add a Customer \t\t 4. remove a customer");
		System.out.println("5. update a Customer \t\t 6.Buy a Stock");
		int option=Utility.retInt();
		doSelectedOperation(option);
	}

	private static void doSelectedOperation(int option) 
	{
		TransactionServiceImplementation transactionServiceImplementation=new TransactionServiceImplementation();
		StockServiceImplementation stockServiceImplementation=new StockServiceImplementation();
		CustomerServiceImplementation customerServiceImplementation=new CustomerServiceImplementation();

		switch(option)
		{
		case 1:
			stockServiceImplementation.addStock();
			break;
		case 2:
			stockServiceImplementation.removeStock();
			break;
		case 3:
			customerServiceImplementation.addCustomer();
			break;
		case 4:
			customerServiceImplementation.removeCustomer();
			break;
		case 5:
			customerServiceImplementation.updateCustomer();
			break;
		case 6:
			transactionServiceImplementation.buy();
			break;
		}
	}
	
}
