package com.vaibhavnaikprojects.carrental.queries;

public class OwnerQueries {
	public static final String INSERT_OWNER="insert into OWNER(ownerType,name,address,status,joiningDate) values(?,?,?,'ACTIVE',CURDATE())";
	public static final String DELETE_OWNERS = "delete from OWNER";
	public static final String UPDATE_OWNER = "update OWNER set address=? where ownerId=?";
	public static final String INACTIVATE_OWNER = "update OWNER set status='INACTIVE' where ownerId=?";
	public static final String GET_OWNERS = "select * from owner";
}