package com.vaibhavnaikprojects.carrental.beans;

public class Car {
	private int vehicleId;
	private String model;
	private int year;
	private String vehicleNo;
	private CarType carType;
	private String status;
	private String leavingDate;
	private String joiningDate;
	private Owner owner;
	
	public Car(int vehicleId, String model, Double year, String vehicleNo, CarType carType, String status,
			String leavingDate, String joiningDate, Owner owner) {
		super();
		this.vehicleId = vehicleId;
		this.model = model;
		this.year = year.intValue();
		this.vehicleNo = vehicleNo;
		this.carType = carType;
		this.status = status;
		this.leavingDate = leavingDate;
		this.joiningDate = joiningDate;
		this.owner = owner;
	}
	public Car(int vehicleId, String model, int year, String vehicleNo, CarType carType, String status,
			String leavingDate, String joiningDate, Owner owner) {
		super();
		this.vehicleId = vehicleId;
		this.model = model;
		this.year = year;
		this.vehicleNo = vehicleNo;
		this.carType = carType;
		this.status = status;
		this.leavingDate = leavingDate;
		this.joiningDate = joiningDate;
		this.owner = owner;
	}
	public Car() {
		super();
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
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
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Car [vehicleId=" + vehicleId + ", model=" + model + ", year=" + year + ", vehicleNo=" + vehicleNo
				+ ", carType=" + carType + ", status=" + status + ", leavingDate=" + leavingDate + ", joiningDate="
				+ joiningDate + ", owner=" + owner + "]";
	}
	
	
}
