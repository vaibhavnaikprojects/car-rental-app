package com.vaibhavnaikprojects.carrental.queries;

public class OwnerQueries {
	public static final String INSERT_OWNER_TYPE = "insert into ownerType(ownerType) values(?)";
	public static final String INSERT_OWNER="insert into OWNER(ownerTypeId,name,address,status,joiningDate) values(?,?,?,'ACTIVE',CURDATE())";
	public static final String DELETE_OWNERS = "delete from OWNER";
	public static final String DELETE_OWNERTYPE = "delete from OWNERTYPE";
	public static final String INACTIVATE_OWNER = "delete from OWNER where ownerId=?";
	public static final String GET_OWNERS = "select * from owner o, ownerType ot where o.ownerTypeId=ot.ownerTypeId";
	public static final String GET_OWNERTYPE = "select * from ownerType";
	
}
