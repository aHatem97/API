//package com.example.demo2;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.api.entities.User;
//import com.example.api.repositories.UserRepository;
//import com.example.api.services.UserService;
//
//@SpringBootTest 
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//
//public class UserTest 
//{
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	@Test
//	public void testCreateUser()
//	{
//		String username = "Abbas";
//		String password = "123";
//		try 
//		{
//			byte[] salt = User.getSalt(); 
//			String hashedPassword = User.hashPassword(password, salt);
//			User user = new User(username, hashedPassword);
//			User savedUser = userService.saveOrUpdate(user);
//			assertNotNull(savedUser);
//			
//		} catch (Exception e) 
//		{
//			
//			e.printStackTrace();
//			fail();
//		}
//	}
//	
//	@Test
//	public void testUpdateUser()
//	{			
//			String newPassword = "123";
//			String usernameToUpdate = "Ahmed";
//			User user = null;
//			try 
//			{
//				user = userService.getUserByUsername("Abbas");
//				try 
//				{
//					byte[] salt = User.getSalt(); 
//					String newPasswordCheck = User.hashPassword(newPassword, salt);
//					User currentPassword= userService.getUserById(1);
//					boolean doesPasswordMatch = currentPassword.getPassword().matches(newPasswordCheck);
//					//boolean doesPasswordMatch = currentPassword.getPassword().matches(currentPassword.getPassword());
//					assertTrue(doesPasswordMatch);
//				
//						try
//						{
//							user = new User(usernameToUpdate, currentPassword.getPassword());
//							user.setUserId(1);
//							
//							userService.update(user);	
//						}	catch (Exception UserCreationFailed) 
//						
//						{				
//							UserCreationFailed.printStackTrace();
//							fail();
//						}	
//				
//				} catch (Exception PasswordValidationFailed) 
//				{				
//					PasswordValidationFailed.printStackTrace();
//					fail();
//				}	
//			} catch(Exception UserValidationFailed) 
//			{
//				UserValidationFailed.printStackTrace();
//				fail();
//			}
//	}
//	
//	@Test
//	public void testDeleteUser()
//	{
//			long id = 4;
//			
//			boolean isExistBeforeDelete = userRepository.findById(id).isPresent();
//			
//			userService.delete(id);
//			
//			boolean isExistAfterDelete = userRepository.findById(id).isPresent();
//			
//			assertTrue(isExistBeforeDelete);
//			assertFalse(isExistAfterDelete);
//	}
//	
//	@Test
//	public void testGetUser()
//	{
//			String username = "Abbas";
//			User user;
//			try 
//			{
//				user = userService.getUserByUsername(username);
//				assertTrue(user.getUsername().matches(username));
//			} catch (Exception e) 
//			{
//				e.printStackTrace();
//				fail();
//			}		
//	}
//}