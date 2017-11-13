package com.vaibhavnaikprojects.carrental.queries;

public class CustomerQueries {
	public static final String INSERT_CUSTOMER="insert into CUSTOMER(name,customerType,phone,status,joiningDate) values(?,?,?,'ACTIVE',CURDATE())";
	public static final String DELETE_CUSTOMERS = "delete from CUSTOMER";
	public static final String UPDATE_CUSTOMER = "update CUSTOMER set phone=? where id=?";
	public static final String INACTIVATE_CUSTOMER = "update CUSTOMER set status='INACTIVE' where id=?";
	public static final String GET_CUSTOMERS = "select * from customer";
	public static final String GET_CUSTOMERS_BY_AVAILABLITY = "select * from customer where status=?";
}
