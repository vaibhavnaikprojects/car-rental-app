package com.vaibhavnaikprojects.carrental.beans;

public class CarType {
	private int carTypeId;
	private String carType;
	private double dailyRate;
	private double weeklyRate;
	
	public CarType() {
		super();
	}
	public CarType(int carTypeId){
		super();
		this.carTypeId = carTypeId;
	}
	public CarType(String carType){
		super();
		this.carType = carType;
	}
	public CarType(int carTypeId, String carType, double dailyRate, double weeklyRate) {
		super();
		this.carTypeId = carTypeId;
		this.carType = carType;
		this.dailyRate = dailyRate;
		this.weeklyRate = weeklyRate;
	}
	public int getCarTypeId() {
		return carTypeId;
	}
	public void setCarTypeId(int carTypeId) {
		this.carTypeId = carTypeId;
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
	@Override
	public String toString() {
		return "CarType [carTypeId=" + carTypeId + ", carType=" + carType + ", dailyRate=" + dailyRate + ", weeklyRate="
				+ weeklyRate + "]";
	}
	
	
}
