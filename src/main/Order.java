package main;

import java.util.*;
import java.io.Serializable;


public class Order implements Serializable {
	Customer customer;
	List<Product> items;
	int orderID;
	boolean complete;
	
	public Order(Customer customer, int orderID, boolean complete) {
		super();
		this.customer = customer;
		items = new ArrayList<Product>();
		this.orderID = orderID;
		this.complete = complete;		
	}
	
	public Order(Customer customer, int orderID) {
		super();
		this.customer = customer;
		items = new ArrayList<Product>();
		this.orderID = orderID;
		complete = false;		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void addItems(Product p) {
		items.add(p);
	}
  
	public void removeItems(Product p) {
		items.remove(p);
	}

	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	public double getOrderCost(Order o) {
		double orderSum = 0;
		for (int i=0;i<o.items.size();i++) {
			Product p = o.items.get(i);
			System.out.println(p.toString());
			orderSum += p.getPrice();
		} return orderSum;
	}
	
	public void printOrderCost(Order o) {
		double orderSum = 0;
		orderSum = o.getOrderCost(o);
		if ((orderSum/100) % 1 != 0) {
			System.out.println(">>>>>>> TOTAL ORDER VALUE = £" + orderSum/100 + " <<<<<<<<\n");
		} else {
			System.out.println(">>>>>>> TOTAL ORDER VALUE = £" + orderSum/100 + "0 <<<<<<<<\n");
		}
	}
	
	public void printItems(Order o) {
		for(int i=0;i<o.items.size();i++) {
			Product p = o.items.get(i);
			System.out.println("[" + (i+1) + "] " + p.toString());
		}
	}
	
	@Override
	public String toString() {
		return "------------ ORDER ID - " + orderID + " ------------\nCustomer name: " + customer.getFirstName() + " " + customer.getSecondName() + ". Order complete: " + complete +".\n        >>>>>>>> ITEMS <<<<<<<<";
	}
}