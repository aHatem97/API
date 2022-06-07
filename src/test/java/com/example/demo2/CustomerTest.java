//package com.example.demo2;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.demo2.entities.Customer;
//import com.example.demo2.repositories.CustomersRepository;
//import com.example.demo2.services.CustomersService;
//
//@SpringBootTest 
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//
//public class CustomerTest 
//{
//	@Autowired
//	private CustomersService customersService;
//	
//	@Autowired
//	private CustomersRepository customersRepository;
//
//	@Test
//	public void testCreateCustomer()
//	{
//
//	}
//	
//	@Test
//	public void testUpdateCustomer()
//	{			
//
//	}
//	
//	@Test
//	public void testDeleteCustomer()
//	{
//			long id = 4;
//			
//			boolean isExistBeforeDelete = customersRepository.findById(id).isPresent();
//			
//			customersService.delete(id);
//			
//			boolean isExistAfterDelete = customersRepository.findById(id).isPresent();
//			
//			assertTrue(isExistBeforeDelete);
//			assertFalse(isExistAfterDelete);
//	}
//	
//	@Test
//	public void testGetCustomer()
//	{
//			String phoneNumber = "01005481600";
//			Customer customer;
//			try 
//			{
//				customer = customersService.getCustomerByPhoneNumber(phoneNumber);
//				assertTrue(customer.getPhoneNumber().matches(phoneNumber));
//			} catch (Exception e) 
//			{
//				e.printStackTrace();
//				fail();
//			}		
//	}
//}