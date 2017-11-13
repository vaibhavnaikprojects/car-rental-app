package com.vaibhavnaikprojects.carrental.queries;

public class CarQueries {
	public static final String INSERT_CAR="insert into CAR(model,year,vehicleNo,carType,dailyRate,weeklyRate,status,joiningDate) values(?,?,?,?,?,?,'AVAILABLE',CURDATE())";
	public static final String DELETE_CARS = "delete from CAR";
	public static final String UPDATE_CAR = "update CAR set dailyRate=?,weeklyRate=? where vehicleId=?";
	public static final String INACTIVATE_CAR = "update CAR set status='UNAVAILABLE' where vehicleId=?";
	public static final String UPDATE_PRICES_BY_TYPE = "update CAR set dailyRate=?,weeklyRate=? where carType=?";
	public static final String GET_CARS = "select * from CAR";
	public static final String GET_CARS_BY_AVAILABLITY = "select * from CAR where status=?";
}
