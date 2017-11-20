package com.vaibhavnaikprojects.carrental.beans;

public class CustomerType {
	private int customerTypeId;
	private String customerType;
	
	public CustomerType() {
		super();
	}
	public CustomerType(int customerTypeId, String customerType) {
		super();
		this.customerTypeId = customerTypeId;
		this.customerType = customerType;
	}
	public int getCustomerTypeId() {
		return customerTypeId;
	}
	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	@Override
	public String toString() {
		return "CustomerType [customerTypeId=" + customerTypeId + ", customerType=" + customerType + "]";
	}
	
}
