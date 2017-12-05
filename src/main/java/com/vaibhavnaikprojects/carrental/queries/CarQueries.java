package com.vaibhavnaikprojects.carrental.queries;

public class CarQueries {
	public static final String INSERT_CAR="insert into CAR(model,year,vehicleNo,carTypeId,status,joiningDate,rentalLocation,ownerId) values(?,?,?,?,'AVAILABLE',CURDATE(),'Arlington',?)";
	public static final String DELETE_CARS = "delete from CAR";
	public static final String DELETE_CARTYPE = "delete from CARTYPE";
	public static final String INACTIVATE_CAR = "delete from CAR where vehicleId=?";
	public static final String UPDATE_PRICES_BY_TYPE = "update CARTYPE set dailyRate=?,weeklyRate=? where carTypeId=?";
	public static final String GET_CARS = "select * from CAR c,Owner o,OwnerType ot,carType ct where c.ownerId=o.ownerId and o.ownerTypeId=ot.ownerTypeId and ct.carTypeId=c.carTypeId";
	public static final String GET_CARS_BY_AVAILABLITY = "select * from car c,carType ct,owner o,ownerType ot " + 
			"where c.carTypeId=ct.carTypeId and c.ownerId=o.ownerId and o.ownerTypeId=ot.ownerTypeId and vehicleId not in( " + 
			"select vehicleId from rental r " + 
			"where (str_to_date(?,'%m/%d/%Y')>r.startDate  " + 
			"and str_to_date(?,'%m/%d/%Y')>r.startDate) " + 
			"or " + 
			"(str_to_date(?,'%m/%d/%Y')>r.endDate " + 
			"and str_to_date(?,'%m/%d/%Y')>r.endDate))";
	public static final String INSERT_CAR_TYPE = "insert into cartype(carType,dailyRate,weeklyRate) values(?,?,?)";
	public static final String GET_CAR_TYPES = "select * from cartype";
	public static final String DELETE_CAR_TYPE = "delete from cartype where carTypeId=?";
	/*public static final String UPDATE_RENTALS_AFTER = "update rental set status='AVAILABLE'";
	public static final String UPDATE_RENTALS_BEFORE = "update rental set status='COMPLETE' where STR_TO_DATE(?,'mm/dd/yyyy') < STR_TO_DATE(endDate,'mm/dd/yyyy')";
	public static final String UPDATE_RENTALS_PROCESS = "update rental set status='INTRANSIT' where STR_TO_DATE(?,'mm/dd/yyyy') BETWEEN STR_TO_DATE(startDate,'mm/dd/yyyy') and STR_TO_DATE(endDate,'mm/dd/yyyy')";*/
	public static final String GET_CARS_BY_OWNER = "select * from CAR c,Owner o,OwnerType ot,carType ct where c.ownerId=o.ownerId and o.ownerTypeId=ot.ownerTypeId and ct.carTypeId=c.carTypeId and c.ownerId=?";	
}
