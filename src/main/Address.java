package main;
import java.io.Serializable;
public class Address implements Serializable {
	String house;
	String addressLine1;
	String addressLine2;
	String country;
	String postCode;
	
	public Address(String house, String addressLine1, String addressLine2, String country, String postCode) {
		super();
		this.house = house;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.country = country;
		this.postCode = postCode;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCounty() {
		return country;
	}

	public void setCounty(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return house + " " + addressLine1 + ", " + addressLine2
				+ ", " + country + ", " + postCode;
	}
	
}
