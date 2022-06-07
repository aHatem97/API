package com.example.api.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.api.entities.Customer;
import com.example.api.entities.Order;
import com.example.api.entities.Product;
import com.example.api.entities.dto.OrderConfirmRequest;
import com.example.api.entities.dto.OrderConfirmResponse;
import com.example.api.services.CustomerService;
import com.example.api.services.OrderService;
import com.example.api.services.ProductService;

@RestController
@RequestMapping(path = "/api/manage/order")
public class OrderController 
{

@Autowired
OrderService orderService;

@Autowired
CustomerService consumerService;

@Autowired
ProductService productService;

/** Creating A Get Mapping That Retrieves All The Orders Details From The Database 
 *   
 * @return
 */
@GetMapping({"/all"})
public List<Order> getAllOrders()
{
	return orderService.getAllOrders();
}

/** Creating A Get Mapping That Retrieves The Detail Of A Specific Order 
 *  
 * @param orderId
 * @return
 */
@GetMapping("/id/{orderId}")  
private Order getOrderById(@PathVariable("orderId") long orderId)   
{  
	return orderService.getOrderById(orderId);  
} 

/** Creating A Get Mapping That Retrieves The Detail Of A Specific Order 
 *  
 * @param trxid
 * @return
 * @throws Exception 
 */
@GetMapping("/trx/{trxid}")  
private Order getOrderByTrxId(@PathVariable("trxid") String trxid) throws Exception   
{  
	return orderService.getOrderByTrxId(trxid);  
}
/** Creating A Delete Mapping That Deletes A Specified Order
 * 
 * @param orderId
 */
@DeleteMapping("/delete/{orderId}")  
private void softDeleteOrder(@PathVariable("orderId") long orderId)   
{  
	orderService.softDelete(orderId);  
}  

/** Creating Post Mapping That Posts The Order Detail In The Database  
 * 
 * @param Order
 * @return
 * @throws Exception
 */
@PostMapping 
private long saveOrder(@RequestBody Order order) throws Exception   
{  
		orderService.saveOrUpdate(order);
		return order.getOrderId();
}  

/** Creating Post Mapping That Saves The Order Details In The Database 
 *  
 * @param order
 * @return
 * @throws Exception
 */
//@PostMapping("/confirm") 
//private OrderConfirmResponse confirmOrder(@RequestBody OrderConfirmRequest req)   
//{  
//	try 
//	{
//		
//		Customer consumer = null;
//		Product product = productService.getProductById(req.getProduct_id());
//		try 
//		{
//		   consumer = consumerService.getCustomerByPhoneNumber("01012645677");
//		}catch(Exception e) 
//		{
//		   consumer = new Customer("Nour Kassar", "01012645677");
//		   consumerService.saveOrUpdate(consumer);
//		}
//		Order order = new Order(consumer, product, req.getNotes(), req.getAmount());
//		order = orderService.saveOrUpdate(order);
//		return new OrderConfirmResponse("Success","0000");
//		
//	}catch(Exception e) 
//	{
//		return new OrderConfirmResponse("fail","9999");
//	}
//
//}  

}