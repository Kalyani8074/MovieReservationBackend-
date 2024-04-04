package com.movie.iservices;
 
import java.util.List;
 
 
 
import com.movie.entites.Customer;
 
 
public interface ICustomerService {
 
	public Customer customerRegistration(Customer customer);
 
	public Customer getCustomerById(long customerId);
 
	public List<Customer> getAllCustomers();
 
	public Customer updateCustomer(Customer customer, long customerId);
	
	public String deleteCustomerById(Customer customer, long customerId);
 
	
	
 
}
 