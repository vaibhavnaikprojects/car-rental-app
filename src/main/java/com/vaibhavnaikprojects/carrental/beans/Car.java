package com.vaibhavnaikprojects.carrental.beans;

public class Car {
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
	public Car() {
		super();
	}
	
	public Car(int vehicleId, String model, double year, String vehicleNo, String carType, double dailyRate,
			double weeklyRate, String status) {
		super();
		this.vehicleId = vehicleId;
		this.model = model;
		this.year = ((Double)year).intValue();
		this.vehicleNo = vehicleNo;
		this.carType = carType;
		this.dailyRate = dailyRate;
		this.weeklyRate = weeklyRate;
		this.status = status;
	}

	public Car(int vehicleId,String model, double year, String vehicleNo, String carType, double dailyRate, double weeklyRate,
			String status,String joiningDate,String leavingDate) {
		super();
		this.vehicleId=vehicleId;
		this.model = model;
		this.year = ((Double)year).intValue();
		this.vehicleNo = vehicleNo;
		this.carType = carType;
		this.dailyRate = dailyRate;
		this.weeklyRate = weeklyRate;
		this.status = status;
		this.joiningDate=joiningDate;
		this.leavingDate=leavingDate;
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
	@Override
	public String toString() {
		return "Car [vehicleId=" + vehicleId + ", model=" + model + ", year=" + year + ", vehicleNo=" + vehicleNo
				+ ", carType=" + carType + ", dailyRate=" + dailyRate + ", weeklyRate=" + weeklyRate + ", status="
				+ status + ", leavingDate=" + leavingDate + ", joiningDate=" + joiningDate + "]";
	}
}
