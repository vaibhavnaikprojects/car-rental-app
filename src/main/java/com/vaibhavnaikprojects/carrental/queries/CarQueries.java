package com.vaibhavnaikprojects.carrental.queries;

public class CarQueries {
	public static final String INSERT_CAR="insert into CAR(model,year,vehicleNo,carType,dailyRate,weeklyRate,status,joiningDate,ownerId) values(?,?,?,?,?,?,'AVAILABLE',CURDATE(),?)";
	public static final String DELETE_CARS = "delete from CAR";
	public static final String DELETE_CARTYPE = "delete from CARTYPE";
	public static final String INACTIVATE_CAR = "update CAR set status='UNAVAILABLE' where vehicleId=?";
	public static final String UPDATE_PRICES_BY_TYPE = "update CARTYPE set dailyRate=?,weeklyRate=? where carTypeId=?";
	public static final String GET_CARS = "select c.*,o.ownerId,o.name,o.ownerType,o.address from CAR c,Owner o where c.ownerId=o.ownerId";
	public static final String GET_CARS_BY_AVAILABLITY = "select c.*,o.ownerId,o.name,o.ownerType,o.address from CAR c,Owner o where c.ownerId=o.ownerId and c.status=?";
	public static final String INSERT_CAR_TYPE = "insert into cartype(carType,dailyRate,weeklyRate) values(?,?,?)";
	public static final String GET_CAR_TYPES = "select * from cartype";	
}
