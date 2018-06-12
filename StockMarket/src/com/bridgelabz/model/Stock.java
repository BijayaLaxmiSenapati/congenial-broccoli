package com.bridgelabz.model;

public class Stock 
{
	private String stockName;
	private int numberOfShareOfCompany;
	private int priceOfEachShare;
	public String getStockName()
	{
		return stockName;
	}
	public void setStockName(String stockName)
	{
		this.stockName = stockName;
	}
	public int getNumberOfShareOfCompany() 
	{
		return numberOfShareOfCompany;
	}
	public void setNumberOfShareOfCompany(int numberOfShareOfCompany) 
	{
		this.numberOfShareOfCompany = numberOfShareOfCompany;
	}
	public int getPriceOfEachShare()
	{
		return priceOfEachShare;
	}
	public void setPriceOfEachShare(int priceOfEachShare) 
	{
		this.priceOfEachShare = priceOfEachShare;
	}
}
