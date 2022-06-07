//package com.example.demo2;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.security.NoSuchAlgorithmException;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.api.entities.Customer;
//import com.example.api.entities.Order;
//import com.example.api.entities.Product;
//import com.example.api.entities.User;
//import com.example.api.repositories.OrderRepository;
//import com.example.api.services.CustomerService;
//import com.example.api.services.OrderService;
//import com.example.api.services.ProductService;
//import com.example.api.services.UserService;
//
//@SpringBootTest 
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//
//public class OrderTest 
//{
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private CustomerService customerService;
//	
//	@Autowired
//	private ProductService productService;
//
//	@Autowired
//	private OrderService orderService;
//	
//	@Autowired
//	private OrderRepository orderRepository;
//
//	@Test
//	public void testCreateOrder()
//	{
//		User user = userService.getUserById(1);
//		Customer customer = null;
//		Product product = null;
//		Order order = null;
//		
//		String username = "Abbas";
//		String password = "123";
//		
//		try 
//		{
//			user = userService.getUserByUsername("Abbas");
//			
//		}	catch (Exception e)  
//		{
//			byte[] salt;
//			try 
//			{
//				salt = User.getSalt();
//				String hashedPassword = User.hashPassword(password, salt);
//				User newUser = new User(username, hashedPassword);
//				User savedUser = userService.saveOrUpdate(newUser);
//				assertNotNull(savedUser);
//			} catch (NoSuchAlgorithmException e1) 
//			{
//				e1.printStackTrace();
//			} 
//	
//		}
//		
//		try 
//		{
//			customer = customerService.getCustomerByPhoneNumber("33333333");
//		} catch(Exception e) 
//		{
//			customer = new Customer("Ali","33333333");
//			customer = customerService.saveOrUpdate(customer);
//			assertNotNull(customer);
//		}
//		
//		try 
//		{
//			product = productService.getProductByProductName("Product Test 333");
//		} catch(Exception e) 
//		{
//			product = new Product("Test333", 333, "333", true, true, user);
//			product = productService.saveOrUpdate(product);
//			assertNotNull(product);
//		}
//		
//		if(customer != null && product != null )
//		{
//			order = new Order(customer, product,"test333",333, "333");
//			
//			orderService.saveOrUpdate(order);
//			
//			assertNotNull(order);
//		}
//	}
//	
//	@Test
//	public void testUpdateOrder()
//	{			
//
//	}
//	
//	@Test
//	public void testDeleteOrder()
//	{
//			long id = 4;
//			
//			boolean isExistBeforeDelete = orderRepository.findById(id).isPresent();
//			
//			orderService.delete(id);
//			
//			boolean isExistAfterDelete = orderRepository.findById(id).isPresent();
//			
//			assertTrue(isExistBeforeDelete);
//			assertFalse(isExistAfterDelete);
//	}
//	
////	@Test
////	public void testGetOrder()
////	{
////			String customerName = "AbbasCustomer";
////			Order order;
////			try 
////			{
////				order = ordersService.getOrderByCustomerName(customerName);
////				assertTrue(order.getName().matches(customerName));
////			} catch (Exception e) 
////			{
////				e.printStackTrace();
////				fail();
////			}		
////	}
//}