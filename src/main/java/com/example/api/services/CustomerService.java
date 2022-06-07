package com.example.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.entities.Customer;
import com.example.api.repositories.CustomerRepository;

import java.util.ArrayList;  
import java.util.List;  

@Service
public class CustomerService 
{
@Autowired   
CustomerRepository customerRepository;

/** Get All Customers
 * 
 * @return
 */
public List<Customer> getAllCustomers()   
{  
	List<Customer> customer = new ArrayList<Customer>();  
	customerRepository.findAll().forEach(customer1 -> customer.add(customer1));  
	return customer;  
}  

/** Getting A Specific Customer By Customer Phone Number
 * 
 * @param phoneNumber
 * @return
 * @throws Exception
 */
public Customer getCustomerByPhoneNumber(String phoneNumber) throws Exception 
{
	Customer customer = customerRepository.findByPhoneNumber(phoneNumber);
	if(customer != null) 
	{
		return customer;
	}
	throw new Exception("Customer "+ phoneNumber +" Not Found!");
}


/** Getting A Specific Customer By Searching With Customer ID
 * 
 * @param customerId
 * @return
 */
public Customer getCustomerById(long customerId)   
{  
	return customerRepository.findById(customerId).get();  
}  

/** Saving A Specific Customer
 *  
 * @param customer
 * @return
 */
public Customer saveOrUpdate(Customer customer)   
{  
	return customerRepository.save(customer);  
}  

/** Deleting Specific Customer By Customer ID
 * 
 * @param customerId
 */
public void delete(long customerId)   
{  
	customerRepository.deleteById(customerId);  
}  

/** Updating A Specific Customer
 *  
 * @param customer
 */
public void update(Customer customer)   
{  
	customerRepository.save(customer);  
}

}