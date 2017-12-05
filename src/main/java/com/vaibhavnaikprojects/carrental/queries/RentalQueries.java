package com.vaibhavnaikprojects.carrental.queries;

public class RentalQueries {
	public static final String DELETE_RENTAL = "delete from rental";
	public static final String DELETE_RENTALTYPE = "delete from rentaltype";
	public static final String OWNER_REPORT = "select * from rental r,owner o,car c,carType ct,ownerType ot,rentalType rt,customer cust,customerType custType where  " + 
			"r.status!='Booked' " + 
			"and r.rentalTypeId=rt.rentalTypeId " + 
			"and r.vehicleId=c.vehicleId " + 
			"and r.ownerId=o.ownerId " + 
			"and c.carTypeId=ct.carTypeId " + 
			"and o.ownerTypeId=ot.ownerTypeId " + 
			"and r.customerId=cust.id " + 
			"and custType.customerTypeId=cust.customerTypeId " + 
			"and str_to_date(?,'%m/%d/%Y')<=r.startDate " + 
			"and str_to_date(?,'%m/%d/%Y')>r.endDate and r.ownerId=?";
	public static final String CAR_TYPE_REPORT = "select * from rental r,owner o,car c,carType ct,ownerType ot,rentalType rt,customer cust,customerType custType where  " + 
			"r.status!='Booked' " + 
			"and r.rentalTypeId=rt.rentalTypeId " + 
			"and r.vehicleId=c.vehicleId " + 
			"and r.ownerId=o.ownerId " + 
			"and c.carTypeId=ct.carTypeId " + 
			"and o.ownerTypeId=ot.ownerTypeId " + 
			"and r.customerId=cust.id " + 
			"and custType.customerTypeId=cust.customerTypeId " + 
			"and str_to_date(?,'%m/%d/%Y')<=r.startDate " + 
			"and str_to_date(?,'%m/%d/%Y')>r.endDate " + 
			"and c.carTypeId=?";
	public static final String OWNER_CAR_REPORT = "select * from rental r,owner o,car c,carType ct,ownerType ot,rentalType rt,customer cust,customerType custType where  " + 
			"r.status!='Booked' " + 
			"and r.rentalTypeId=rt.rentalTypeId " + 
			"and r.vehicleId=c.vehicleId " + 
			"and r.ownerId=o.ownerId " + 
			"and c.carTypeId=ct.carTypeId " + 
			"and o.ownerTypeId=ot.ownerTypeId " + 
			"and r.customerId=cust.id " + 
			"and custType.customerTypeId=cust.customerTypeId " + 
			"and str_to_date(?,'%m/%d/%Y')<=r.startDate " + 
			"and str_to_date(?,'%m/%d/%Y')>r.endDate " + 
			"and r.vehicleId=? and r.ownerId=?";
	public static final String INSERT_RENTAL = "insert into RENTAL(noOfRentalType,rentalTypeId,vehicleId,ownerId,customerId,startDate,endDate,status,createdDate,amountDue) "
												+ "values(:noOfRentalType,:rentalTypeId,:vehicleId,:ownerId,:customerId,STR_TO_DATE(:startDate,'%m/%d/%Y'),STR_TO_DATE(:endDate,'%m/%d/%Y'),'BOOKED',CURDATE(),:amountDue)";
	public static final String UPDATE_CAR_STATUS="update car set status=? where vehicleId=?";
	public static final String RETURN_CAR="update RENTAL set status='COMPLETED' where rentalId=?";
	public static final String GET_RENTED_CARS = "select * from CAR c,Owner o,OwnerType ot,carType ct,rental r where c.ownerId=o.ownerId and o.ownerTypeId=ot.ownerTypeId and ct.carTypeId=c.carTypeId and r.vehicleId=c.vehicleId and r.customerId=? and r.status='BOOKED'";
	public static final String GET_RENTAL_DETAILS="select * from rental r,rentalType rt,car c,carType ct, owner o,ownerType ot where r.customerId=?  " + 
			"and r.vehicleId=?  " + 
			"and r.status='BOOKED'  " + 
			"and rt.rentalTypeId=r.rentalTypeId " + 
			"and c.carTypeId=ct.carTypeId " + 
			"and r.vehicleId=c.vehicleId " + 
			"and r.ownerId=o.ownerId " + 
			"and ot.ownerTypeId=o.ownerTypeId";
}
