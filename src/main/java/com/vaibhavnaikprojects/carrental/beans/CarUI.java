package com.vaibhavnaikprojects.carrental.beans;

public class CarUI {
	private int vehicleId;
	private String model;
	private int year;
	private String vehicleNo;
	private String carType;
	private double dailyRate;
	private double weeklyRate;
	private String status;
	private String leavingDate;
	private String joiningDate;
	private String ownerName;
	
	public CarUI(Car car,String carType, double dailyRate,double weeklyRate, String ownerName) {
		super();
		this.vehicleId = car.getVehicleId();
		this.model = car.getModel();
		this.year = car.getYear();
		this.vehicleNo = car.getVehicleNo();
		this.carType = carType;
		this.dailyRate = dailyRate;
		this.weeklyRate = weeklyRate;
		this.status = car.getStatus();
		this.leavingDate = car.getLeavingDate();
		this.joiningDate = car.getJoiningDate();
		this.ownerName = ownerName;
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
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public double getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}
	public double getWeeklyRate() {
		return weeklyRate;
	}
	public void setWeeklyRate(double weeklyRate) {
		this.weeklyRate = weeklyRate;
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
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	@Override
	public String toString() {
		return "CarUI [vehicleId=" + vehicleId + ", model=" + model + ", year=" + year + ", vehicleNo=" + vehicleNo
				+ ", carType=" + carType + ", dailyRate=" + dailyRate + ", weeklyRate=" + weeklyRate + ", status="
				+ status + ", leavingDate=" + leavingDate + ", joiningDate=" + joiningDate + ", ownerName=" + ownerName
				+ "]";
	}
}
