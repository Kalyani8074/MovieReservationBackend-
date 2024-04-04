package com.movie.services;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entites.Customer;
import com.movie.iservices.ICustomerService;
import com.movie.repositories.CustomerRespository;
 
 
@Service
public class CustomerService implements ICustomerService {
 
	@Autowired
	private CustomerRespository customerRepository;
 
 
	@Override
	public Customer customerRegistration(Customer customer) {
 
		return customerRepository.save(customer);
	}
 
	@Override
	public Customer updateCustomer(Customer customer, long customerId) {
 
		if (customerRepository.existsById(customerId)) {
 
			customer.setCustomerId(customerId);
			customerRepository.save(customer);
 
		} else {
			System.out.println("Id doesnot exists");
		}
 
		return customer;
 
	}
 
	@Override
	public Customer getCustomerById(long customerId) {
 
		return customerRepository.findById(customerId).orElse(null);
	}
 
	@Override
	public List<Customer> getAllCustomers() {
 
		return customerRepository.findAll();
	}
	@Override
	public String deleteCustomerById(Customer customer, long customerId) {
		customerRepository.deleteById(customerId);
		return "employee deleted successfully";
	}
 
	

	}