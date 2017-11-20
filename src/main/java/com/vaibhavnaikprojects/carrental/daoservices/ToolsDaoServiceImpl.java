package com.vaibhavnaikprojects.carrental.daoservices;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.vaibhavnaikprojects.carrental.beans.Car;
import com.vaibhavnaikprojects.carrental.beans.CarType;
import com.vaibhavnaikprojects.carrental.beans.Customer;
import com.vaibhavnaikprojects.carrental.beans.CustomerType;
import com.vaibhavnaikprojects.carrental.beans.Owner;
import com.vaibhavnaikprojects.carrental.beans.OwnerType;
import com.vaibhavnaikprojects.carrental.mappers.CarTypeMapper;
import com.vaibhavnaikprojects.carrental.mappers.CustomerTypeMapper;
import com.vaibhavnaikprojects.carrental.mappers.OwnerMapper;
import com.vaibhavnaikprojects.carrental.mappers.OwnerTypeMapper;
import com.vaibhavnaikprojects.carrental.queries.CarQueries;
import com.vaibhavnaikprojects.carrental.queries.CustomerQueries;
import com.vaibhavnaikprojects.carrental.queries.OwnerQueries;
import com.vaibhavnaikprojects.carrental.queries.RentalQueries;

@Repository
public class ToolsDaoServiceImpl extends JdbcDaoSupport{
	@SuppressWarnings("unchecked")
	public void insertRecords(Map<String, Object> excelSheetObj) {
		deleteRecords();
		final List<String> ownerTypes=(List<String>)excelSheetObj.get("ownerType");
		getJdbcTemplate().batchUpdate(OwnerQueries.INSERT_OWNER_TYPE, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return ownerTypes.size();
			}
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				String ownerType = ownerTypes.get(i);
				ps.setString(1, ownerType);
			}
		});
		List<OwnerType> dbOwnerTypes=getJdbcTemplate().query(OwnerQueries.GET_OWNERTYPE, new OwnerTypeMapper());
		final Map<String, Integer> ownerTypeMap=new HashMap<String, Integer>();
		for (OwnerType ownerType : dbOwnerTypes) {
			ownerTypeMap.put(ownerType.getOwnerType(),ownerType.getOwnerTypeId());
		}
		final List<Owner> owners=(List<Owner>) excelSheetObj.get("owners");
		getJdbcTemplate().batchUpdate(OwnerQueries.INSERT_OWNER, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return owners.size();
			}
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Owner owner = owners.get(i);
				ps.setInt(1,ownerTypeMap.get(owner.getOwnerType()));
				ps.setString(2,owner.getName());
				ps.setString(3,owner.getAddress());	
			}
		});
		final List<String> customerTypes=(List<String>)excelSheetObj.get("customerType");
		getJdbcTemplate().batchUpdate(CustomerQueries.INSERT_CUSTOMER_TYPE, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return customerTypes.size();
			}
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				String customerType = customerTypes.get(i);
				ps.setString(1, customerType);
			}
		});
		List<CustomerType> dbCustomerTypes=getJdbcTemplate().query(CustomerQueries.GET_CUSTOMERTYPE, new CustomerTypeMapper());
		final Map<String, Integer> customerTypeMap=new HashMap<String, Integer>();
		for (CustomerType customerType : dbCustomerTypes) {
			customerTypeMap.put(customerType.getCustomerType(),customerType.getCustomerTypeId());
		}
		final List<Customer> customers=(List<Customer>)excelSheetObj.get("customers");
		getJdbcTemplate().batchUpdate(CustomerQueries.INSERT_CUSTOMER, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return customers.size();
			}
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Customer customer = customers.get(i);
				ps.setString(1, customer.getName());
				ps.setInt(2, customerTypeMap.get(customer.getCustomerType()));
				ps.setString(3, customer.getPhone());
			}
		});
		final List<CarType> carTypes=(List<CarType>)excelSheetObj.get("carType");
		getJdbcTemplate().batchUpdate(CarQueries.INSERT_CAR_TYPE, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return carTypes.size();
			}
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				CarType carType = carTypes.get(i);
				ps.setString(1, carType.getCarType());
				ps.setDouble(2, carType.getDailyRate());
				ps.setDouble(3, carType.getWeeklyRate());
			}
		});
		List<CarType> dbCarTypes=getJdbcTemplate().query(CarQueries.GET_CAR_TYPES, new CarTypeMapper());
		List<Owner> dbOwners=getJdbcTemplate().query(OwnerQueries.GET_OWNERS, new OwnerMapper());
		final Map<String, Integer> ownerMap=new HashMap<String, Integer>();
		for (Owner owner : dbOwners) {
			ownerMap.put(owner.getName(),owner.getOwnerId());
		}
		final Map<String, Integer> carTypeMap=new HashMap<String, Integer>();
		for(CarType carType:dbCarTypes) {
			carTypeMap.put(carType.getCarType(), carType.getCarTypeId());
		}
		final List<Car> cars=(List<Car>) excelSheetObj.get("cars");
		getJdbcTemplate().batchUpdate(CarQueries.INSERT_CAR, new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return cars.size();
			}
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Car car = cars.get(i);
				ps.setString(1,car.getModel());
				ps.setInt(2,car.getYear());
				ps.setString(3,car.getVehicleNo());
				ps.setInt(4,carTypeMap.get(car.getCarType().getCarType()));
				ps.setInt(5,ownerMap.get(car.getOwner().getName()));
			}
		});
	}

	public void deleteRecords() {
		getJdbcTemplate().update(RentalQueries.DELETE_RENTAL);
		getJdbcTemplate().update(RentalQueries.DELETE_RENTALTYPE);
		getJdbcTemplate().update(CarQueries.DELETE_CARS);
		getJdbcTemplate().update(CarQueries.DELETE_CARTYPE);
		getJdbcTemplate().update(CustomerQueries.DELETE_CUSTOMERS);
		getJdbcTemplate().update(CustomerQueries.DELETE_CUSTOMER_TYPE);
		getJdbcTemplate().update(OwnerQueries.DELETE_OWNERS);
		getJdbcTemplate().update(OwnerQueries.DELETE_OWNERTYPE);
	}
}
