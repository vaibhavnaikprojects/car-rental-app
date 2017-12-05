package com.vaibhavnaikprojects.carrental.beans;

public class Customer {
	private int id;
	private String name;
	private String customerType;
	private String phone;
	private String status;
	private String leavingDate;
	private String joiningDate;
	public Customer() {
	}
	
	public Customer(int id) {
		super();
		this.id = id;
	}

	public Customer(int id, String name, String customerType, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.customerType = customerType;
		this.phone = phone;
	}

	public Customer(int id, String name, String customerType, String phone, String status,String joiningDate, String leavingDate) {
		super();
		this.id = id;
		this.name = name;
		this.customerType = customerType;
		this.phone = phone;
		this.status = status;
		this.leavingDate = leavingDate;
		this.joiningDate = joiningDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLeavingDate() {
		return leavingDate;
	}
	public void setLeavingDate(String leavingDate) {
		this.leavingDate = leavingDate;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	@Override
	public String toString() {
		return "Customer [Id=" + id + ", name=" + name + ", customerType=" + customerType + ", phone=" + phone
				+ ", status=" + status + ", leavingDate=" + leavingDate + ", joiningDate=" + joiningDate + "]";
	}
}
