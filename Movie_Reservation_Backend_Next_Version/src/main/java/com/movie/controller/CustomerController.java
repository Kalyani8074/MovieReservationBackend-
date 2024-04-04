package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entites.Customer;
import com.movie.iservices.ICustomerService;

@RestController
@CrossOrigin("http://localhost:4200")
public class CustomerController {
 
	@Autowired
	private ICustomerService customerService;
 
	@PostMapping("/add")
	public Customer customerRegistration(@RequestBody Customer customer) {
		return customerService.customerRegistration(customer);
	}
 
	@PutMapping("/updateCustomer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") int customerId) {
		return customerService.updateCustomer(customer, customerId);
	}
 
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		return customerService.getCustomerById(customerId);
	}
 
	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(Customer customer,@PathVariable ("id") int id) {
		return customerService.deleteCustomerById(customer, id);
	}
	

	
 
}