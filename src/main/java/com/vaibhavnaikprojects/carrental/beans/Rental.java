package com.vaibhavnaikprojects.carrental.beans;

public class Rental {
	private int rentalId;
	private String rentalType;
	private Customer customer;
	private Car car;
	private Owner owner;
	private int noOfRentalType;
	private String startDate;
	private String returnDate;
	private double amountDue;
	public Rental() {
	}

	public Rental(int rentalId, String rentalType, Customer customer, Car car, Owner owner, int noOfRentalType,
			String startDate, String returnDate, double amountDue) {
		super();
		this.rentalId = rentalId;
		this.rentalType = rentalType;
		this.customer = customer;
		this.car = car;
		this.owner = owner;
		this.noOfRentalType = noOfRentalType;
		this.startDate = startDate;
		this.returnDate = returnDate;
		this.amountDue = amountDue;
	}

	public int getRentalId() {
		return rentalId;
	}
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public String getRentalType() {
		return rentalType;
	}
	public void setRentalType(String rentalType) {
		this.rentalType = rentalType;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public int getNoOfRentalType() {
		return noOfRentalType;
	}
	public void setNoOfRentalType(int noOfRentalType) {
		this.noOfRentalType = noOfRentalType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public double getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}
	@Override
	public String toString() {
		return "Rental [rentalId=" + rentalId + ", rentalType=" + rentalType + ", customer=" + customer + ", car=" + car
				+ ", owner=" + owner + ", noOfRentalType=" + noOfRentalType + ", startDate=" + startDate
				+ ", returnDate=" + returnDate + ", amountDue=" + amountDue + "]";
	}
}
