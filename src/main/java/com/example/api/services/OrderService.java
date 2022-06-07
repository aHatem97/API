package com.example.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.entities.Order;
import com.example.api.repositories.OrderRepository;

import java.util.ArrayList;  
import java.util.List;  

@Service
public class OrderService 
{
	
@Autowired   
OrderRepository orderRepository;

/** Getting All Orders
 * 
 * @return
 */
public List<Order> getAllOrders()   
{  
	List<Order> order = new ArrayList<Order>();  
	orderRepository.findAll().forEach(order1 -> order.add(order1));  
	return order;  
}  

/** Getting A Specific Order By Order ID
 * 
 * @param orderId
 * @return
 */
public Order getOrderById(long orderId)   
{  
	return orderRepository.findById(orderId).get();  
} 

/** Getting A Specific Order By trxid
 * 
 * @param trxid
 * @return
 * @throws Exception
 */
public Order getOrderByTrxId(String trxid) throws Exception
{
	Order order = orderRepository.findByTrxid(trxid);
	if(order != null) 
	{
		return order;
	}
	throw new Exception("Order "+ trxid +" Not Found!");
}

/** Saving A Specific Order
 * 
 * @param order
 * @return
 */
public Order saveOrUpdate(Order order)   
{  
	return orderRepository.save(order);  
}  

/** Deleting A Specific Order By Order ID
 * 
 * @param orderId
 */
public void softDelete(long orderId)   
{  
	orderRepository.softDelete(orderId);  
}  

/** Updating A Specific Order
 * 
 * @param order
 */
public void update(Order order)   
{  
	orderRepository.save(order);  
}
}