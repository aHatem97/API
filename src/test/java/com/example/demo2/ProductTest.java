//package com.example.demo2;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.demo2.entities.Product;
//import com.example.demo2.entities.User;
//import com.example.demo2.repositories.ProductRepository;
//import com.example.demo2.services.ProductService;
//import com.example.demo2.services.UserService;
//
//@SpringBootTest 
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//
//public class ProductTest 
//{
//	@Autowired
//	private ProductService productService;
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private ProductRepository productRepository;
//
//	@Test
//	public void testCreateProduct()
//	{
//		User user = userService.getUserById(1);
//		Product product = new Product("Product 9", 9, "9", false, true, user);
//		Product savedProduct = productService.saveOrUpdate(product);
//			
//		assertNotNull(savedProduct);
//	}
//	
//	@Test
//	public void testUpdateProduct()
//	{			
//		String productName = "AbbasUpdateTest";
//		Product product = new Product(productName, 1, "50", true, true);
//		product.setProductId(1);
//		
//		productsService.update(product);
//		Product updatedProduct;
//		try 
//		{
//			updatedProduct = productsService.getProductByProductName(productName);
//			boolean doesProductNameMatch = updatedProduct.getProductName().matches(productName);
//			
//			assertTrue(doesProductNameMatch);
//		} catch (Exception e) 
//		{
//			e.printStackTrace();
//			fail();
//		}
//	}
//	
//	@Test
//	public void testDeleteProduct()
//	{
//			long id = 1;
//			
//			boolean isExistBeforeDelete = productRepository.findById(id).isPresent();
//			
//			productsService.delete(id);
//			
//			boolean isExistAfterDelete = productRepository.findById(id).isPresent();
//			
//			assertTrue(isExistBeforeDelete);
//			assertFalse(isExistAfterDelete);
//	}
//	
//	@Test
//	public void testGetProduct()
//	{
//			String productName = "Abbas Product";
//			Product product;
//			try 
//			{
//				product = productsService.getProductByProductName(productName);
//				assertTrue(product.getProductName().matches(productName));
//			} catch (Exception e) 
//			{
//				e.printStackTrace();
//				fail();
//			}		
//	}
//}