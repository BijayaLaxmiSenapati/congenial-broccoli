package com.bridgelabz.model;

public class Transaction 
{
	private String StockName;
	private String customerName;
	private int numberOfShareBought;
	private int totalPrice;
	public String getStockName() 
	{
		return StockName;
	}
	public void setStockName(String stockName)
	{
		StockName = stockName;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	public int getNumberOfShareBought()
	{
		return numberOfShareBought;
	}
	public void setNumberOfShareBought(int numberOfShareBought) 
	{
		this.numberOfShareBought = numberOfShareBought;
	}
	
}
