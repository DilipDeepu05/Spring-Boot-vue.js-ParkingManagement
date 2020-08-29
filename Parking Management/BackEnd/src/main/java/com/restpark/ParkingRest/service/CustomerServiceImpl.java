package com.restpark.ParkingRest.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restpark.ParkingRest.dao.CustomerDao;
import com.restpark.ParkingRest.model.Customer;
import com.restpark.ParkingRest.model.Details;


@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerdao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerdao) {
		this.customerdao = customerdao;
	}


	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerdao.getCustomers();
	}

	@Override
	@Transactional
	public Customer findById(int id) {
		return customerdao.findById(id);
	}


	@Override
	@Transactional
	public void save(Customer c) {
		customerdao.save(c);
	}


	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		customerdao.delete(id);
	}


	@Override
	@Transactional
	public List<Details> getDetails() {
		return customerdao.getDetails();
	}


	


	@Override
	@Transactional
	public Details clockOut(Customer c) {
		return customerdao.clockOut(c);
	}




}
