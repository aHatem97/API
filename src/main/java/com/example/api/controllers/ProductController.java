package com.example.api.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entities.Product;
import com.example.api.services.ProductService;

@RestController
@RequestMapping(path = "/api/manage/product")
public class ProductController 
{

@Autowired
ProductService productService;

/** Creating A Get Mapping That Retrieves All The Products Details From The Database 
 *   
 * @return
 */
@GetMapping({"/all"})
public List<Product> getAllProducts()
{
	return productService.getAllProducts();
}

/** Creating A Get Mapping That Retrieves The Detail Of A Specific Product 
 *  
 * @param productId
 * @return
 */
@GetMapping("/id/{productId}")  
private Product getProductById(@PathVariable("productId") long productId)   
{  
	return productService.getProductById(productId);  
} 

/** Creating A Get Mapping That Retrieves The Detail Of A Specific Product 
 *  
 * @param productName
 * @return
 * @throws Exception 
 */
@GetMapping("/pos/{posTerminalId}")  
private Product getProductByPosTerminalId(@PathVariable("posTerminalId") String posTerminalId) throws Exception   
{  
	return productService.getProductByProductName(posTerminalId);  
} 

/** Creating A Get Mapping That Retrieves The Detail Of A Specific Product 
 *  
 * @param productName
 * @return
 * @throws Exception 
 */
@GetMapping("/name/{productName}")  
private Product getProductByProductName(@PathVariable("productName") String productName) throws Exception   
{  
	return productService.getProductByProductName(productName);  
} 

/** Creating A Delete Mapping That Deletes A Specified Product
 * 
 * @param productId
 */
@DeleteMapping("/delete/{productId}")  
private void softDeleteProduct(@PathVariable("productId") long productId)   
{  
	productService.softDelete(productId);  
}  

/** Creating Post Mapping That Posts The Product Detail In The Database  
 * 
 * @param product
 * @return
 * @throws Exception
 */
@PostMapping 
private long saveProduct(@RequestBody Product product) throws Exception   
{  
		Product p = productService.saveOrUpdate(product);
		return p.getProductId();
}  

/** Creating Put Mapping That Updates The Product Detail
 * 
 * @param product
 * @return
 */
@PutMapping
private Product update(@RequestBody Product product)   
{  
	productService.saveOrUpdate(product);  
	return product;  
}  

}