package main;

import java.io.Serializable;

public class Customer implements Serializable {
	String customerID; //changed to string but still treat as number - i.e its tested with a try/catch on parseInt. 
	String firstName;
	String secondName;
	Address address;
	String telephoneNumber;
	
	public Customer(String customerID, String firstName, String secondName, Address address, String telephoneNumber) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.secondName = secondName;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
	}

	public String getCID() {
		return customerID;
	}

	public void setCID(String customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Override
	public String toString() {
		return customerID + ": " + firstName + " " + secondName
				+ ". " + address + ". Tel: " + telephoneNumber;
	}
	
	
}
