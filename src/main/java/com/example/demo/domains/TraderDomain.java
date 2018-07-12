package com.example.demo.domains;

public class TraderDomain {
	 private int traderId;
	 private String firstName;
	 private String lastName;
	 private String email;
	 private String address;
	 private double contact;
	
	 
	 
	 public TraderDomain()
	 {
		 
	 }
	 public TraderDomain(int traderId, String firstName, String lastName, String email, String address, double contact) {
		super();
		this.traderId = traderId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "ProjectDomain [tradeId=" + traderId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", address=" + address + ", contact=" + contact + "]";
	}
	
	public int getTraderId() {
		return traderId;
	}
	public void setTraderId(int tradeId) {
		this.traderId = tradeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getContact() {
		return contact;
	}
	public void setContact(double d) {
		this.contact = d;
	}
}
