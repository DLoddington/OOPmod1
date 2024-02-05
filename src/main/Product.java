package main;

import java.io.Serializable;

public class Product implements Serializable {
	private String SKU;
	private String description;
	private double price;
	private int stockCount;
	
	public Product(String SKU, String description, double price, int stockCount) {
		this.SKU = SKU ;
		this.description = description;
		this.price = (price);
		this.stockCount = stockCount;
	}
	
	public Product(String SKU, String description, double price) {
		this.SKU = SKU ;
		this.description = description;
		this.price = (price);
	}


	public String getSKU() {
		return SKU;
	}

	public void setSKU(String SKU) {
		this.SKU = SKU;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
			return price;		
	}// resolve how to getPrice with correct decimal places later. 

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStockCount() {
		return stockCount;
	}
	
	public void removeStock(int amountToRemove) {
		this.stockCount = stockCount - amountToRemove;
	}
	
	public void addStock(int amountToAdd) {
		this.stockCount = stockCount + amountToAdd;
	}
	@Override
	public String toString(){
		if ((price/100) % 1 != 0)
			return "SKU: " + SKU + ", " + description + ", price = £" + price/100 + ". Stock count = " + stockCount + ".";
		else
			return "SKU: " + SKU + ", " + description + ", price = £" + price/100 + "0. Stock count = " + stockCount + "."; // covers whole number price case £X.0 -> £X.00
	}

	public String toStringWithoutStock() {
		if ((price/100) % 1 != 0)
			return "SKU: " + SKU + ", " + description + ", price = £" + price/100 + ".";
		else
			return "SKU: " + SKU + ", " + description + ", price = £" + price/100 + "0."; // covers whole number price case £X.0 -> £X.00
	}
	
	public String toStringWithStockWithoutPrice() {

			return "SKU: " + SKU + ", " + description + ". Stock count = " + stockCount + ".";

	}
	
}