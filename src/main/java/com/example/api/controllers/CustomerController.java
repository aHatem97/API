package com.example.api.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entities.Customer;
import com.example.api.services.CustomerService;

@RestController
@RequestMapping(path = "/api/manage/customer")
public class CustomerController 
{

@Autowired
CustomerService customerService;

/** Creating A Get Mapping That Retrieves All The Customers Details From The Database 
 *   
 * @return
 */
@GetMapping("/all")
public List<Customer> getAllCustomers()
{
    return customerService.getAllCustomers();
}

/** Creating A Get Mapping That Retrieves The Details Of A Specific Customer
 * 
 * @param customerId
 * @return
 */

@GetMapping("/id/{customerId}")  
private Customer getCustomerByCustomerId(@PathVariable("customerId") long customerId)   
{  
return customerService.getCustomerById(customerId);  
}  


/** Creating A Get Mapping That Retrieves The Details Of A Specific Customer by Phonenumber
 * 
 * @param phoneNumber
 * @return
 * @throws Exception
 */

@GetMapping("/phone/{phoneNumber}")  
private Customer getCustomerByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) throws Exception   
{  
	return customerService.getCustomerByPhoneNumber(phoneNumber);  
}  

/** Creating A Delete Mapping That Deletes A Specified Customer
 * 
 * @param customerId
 */
@DeleteMapping("id/{customerId}")  
private void deleteCustomer(@PathVariable("customerId") long customerId)   
{  
	customerService.delete(customerId);  
}  

/** Creating Post Mapping That Posts The Customer Details In The Database
 * 
 * @param customer
 * @return
 * @throws Exception
 */
@PostMapping 
private long saveCustomer(@RequestBody Customer customer) throws Exception   
{  
	try 
	{
		Customer c = customerService.saveOrUpdate(customer);
		return c.getCustomerId();
	} catch(Exception e) {
		throw new Exception(e.toString());
	}
}  

}