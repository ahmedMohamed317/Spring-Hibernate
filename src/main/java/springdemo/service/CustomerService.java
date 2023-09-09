package springdemo.service;

import java.util.List;

import springdemo.entity.Customer;

public interface CustomerService {
	
	
	public List<Customer> getCustomer();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);

}
