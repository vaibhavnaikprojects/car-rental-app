package com.vaibhavnaikprojects.carrental.queries;

public class CustomerQueries {
	public static final String INSERT_CUSTOMER="insert into CUSTOMER(name,customerTypeId,phone,status,joiningDate) values(?,?,?,'ACTIVE',CURDATE())";
	public static final String DELETE_CUSTOMER_TYPE = "delete from CUSTOMERTYPE";
	public static final String DELETE_CUSTOMERS = "delete from CUSTOMER";
	public static final String INACTIVATE_CUSTOMER = "update CUSTOMER set status='INACTIVE' where id=?";
	public static final String GET_CUSTOMERS = "select * from customer c,customertype ct where c.customerTypeId=ct.customerTypeId";
	public static final String GET_CUSTOMERS_BY_AVAILABLITY = "select * from customer c,customertype ct where c.customerTypeId=ct.customerTypeId where status=?";
	public static final String INSERT_CUSTOMER_TYPE = "insert into customertype(customerType) values(?)";
	public static final String GET_CUSTOMERTYPE = "select * from customertype";
}
