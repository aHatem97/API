package com.example.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.entities.Product;
import com.example.api.repositories.ProductRepository;

import java.util.ArrayList;  
import java.util.List;

@Service
public class ProductService 
{
@Autowired   
ProductRepository productRepository;

/** Getting All Products
 * 
 * @return
 */
public List<Product> getAllProducts()   
{  
	List<Product> product = new ArrayList<Product>();  
	productRepository.findAll().forEach(product1 -> product.add(product1));  
	return product;  
}  

/** Getting A Specific Product By Product Name
 * 
 * @param productName
 * @return
 * @throws Exception
 */
public Product getProductByProductName(String productName) throws Exception 
{
	Product product = productRepository.findByProductName(productName);
	if(product != null) 
	{
		return product;
	}
	throw new Exception("Product "+ productName +" Not Found!");
}

/** Getting A Specific Product By PosTerminalId
 * 
 * @param posTerminalId
 * @return
 * @throws Exception
 */
public Product getProductByPosTerminalId(String posTerminalId) throws Exception
{
	Product product = productRepository.findByPosTerminalId(posTerminalId);
	if(product != null) 
	{
		return product;
	}
	throw new Exception("Product "+ posTerminalId +" Not Found!");
}

/** Getting A Specific Product By Using Product ID
 * 
 * @param productId
 * @return
 */
public Product getProductById(long productId)   
{  
	return productRepository.findById(productId).get();  
}  

/** Saving A Specific Product
 * 
 * @param product
 * @return
 */
public Product saveOrUpdate(Product product)   
{  
	return productRepository.save(product);  
}  

/** Deleting A Specific Product By Product ID
 * 
 * @param productId
 */
public void softDelete(long productId)   
{  
	productRepository.softDelete(productId);  
}  

/** Updating A Specific Product
 * 
 * @param product
 */
public void update(Product product)   
{  
	productRepository.save(product);  
}
}