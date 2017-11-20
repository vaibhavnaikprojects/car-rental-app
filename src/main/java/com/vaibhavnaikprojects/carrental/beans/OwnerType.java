package com.vaibhavnaikprojects.carrental.beans;

public class OwnerType {
	private int ownerTypeId;
	private String ownerType;
	
	public OwnerType() {
		super();
	}
	public OwnerType(int ownerTypeId, String ownerType) {
		super();
		this.ownerTypeId = ownerTypeId;
		this.ownerType = ownerType;
	}
	public int getOwnerTypeId() {
		return ownerTypeId;
	}
	public void setOwnerTypeId(int ownerTypeId) {
		this.ownerTypeId = ownerTypeId;
	}
	public String getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	@Override
	public String toString() {
		return "OwnerType [ownerTypeId=" + ownerTypeId + ", ownerType=" + ownerType + "]";
	}
	
}
