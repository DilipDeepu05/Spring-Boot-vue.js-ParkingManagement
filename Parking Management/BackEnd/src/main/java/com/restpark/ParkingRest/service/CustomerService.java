package com.restpark.ParkingRest.service;

import java.util.List;

import com.restpark.ParkingRest.model.Customer;
import com.restpark.ParkingRest.model.Details;


public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer findById(int id);
	
	public void save(Customer c);
	
	public void delete(int id);

	public List<Details> getDetails();

	public Details clockOut(Customer c);
}
