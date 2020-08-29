package com.restpark.ParkingRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restpark.ParkingRest.model.Customer;
import com.restpark.ParkingRest.model.Details;
import com.restpark.ParkingRest.service.CustomerService;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/parking")
public class ParkingRestController {

	@Autowired
	private CustomerService customerservice;
	
	
	@GetMapping("/customer")
	public List<Customer> showCustomers() {
	List<Customer>	c= customerservice.getCustomers();
	return c;
	}	
	
	@GetMapping("/Billing")
	public List<Details> showBilling(){
		List<Details> d=customerservice.getDetails();
		return d;
	}
	
	@GetMapping("/search/{customerId}")
	public Customer showCustomer(@PathVariable int customerId) {
		Customer c=customerservice.findById(customerId);
		return c;
	}
	
	@PostMapping("/customer")
	public void addCustomer(@RequestBody Customer c) {
		customerservice.save(c);
	}
	
	@PutMapping("/customer")
	public void updateCustomer(@RequestBody Customer c) {
		customerservice.save(c);
	}
	
	@GetMapping("/activeBilling/{customerId}")
	public Details activeBilling(@PathVariable int customerId) {
		Customer c=customerservice.findById(customerId);
		Details d=customerservice.clockOut(c);
		return d;
	}
	
}
