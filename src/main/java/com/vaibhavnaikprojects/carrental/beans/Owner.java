package com.vaibhavnaikprojects.carrental.beans;

public class Owner{
	private int ownerId;
	private String ownerType;
	private String name;
	private String address;
	private String status;
	private String leavingDate;
	private String joiningDate;
	public Owner() {
		super();
	}
	public Owner(int ownerId) {
		super();
		this.ownerId = ownerId;
	}
	public Owner(String name) {
		super();
		this.name = name;
	}
	
	public Owner(int ownerId, String name) {
		super();
		this.ownerId = ownerId;
		this.name = name;
	}
	public Owner(int ownerId, String ownerType, String name, String address) {
		super();
		this.ownerId = ownerId;
		this.ownerType = ownerType;
		this.name = name;
		this.address = address;
	}


	public Owner(int ownerId, String ownerType, String name, String address, String status, String leavingDate,
			String joiningDate) {
		super();
		this.ownerId = ownerId;
		this.ownerType = ownerType;
		this.name = name;
		this.address = address;
		this.status = status;
		this.leavingDate = leavingDate;
		this.joiningDate = joiningDate;
	}

	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
		return "Owner [ownerId=" + ownerId + ", ownerType=" + ownerType + ", name=" + name + ", address=" + address
				+ ", status=" + status + ", leavingDate=" + leavingDate + ", joiningDate=" + joiningDate + "]";
	}
}
