package com.example.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.entities.User;
import com.example.api.repositories.UserRepository;

import java.util.ArrayList;  
import java.util.List;  

@Service
public class UserService 
{
@Autowired   
UserRepository userRepository;

/** Getting All Users
 * 
 * @return
 */
public List<User> getAllUsers()   
{  
	List<User> user = new ArrayList<User>();  
	userRepository.findAll().forEach(user1 -> user.add(user1));  
	return user;  
}  

/** Getting A Specific User By Username
 * 
 * @param username
 * @return
 * @throws Exception
 */
public User getUserByUsername(String username) throws Exception 
{
	User user = userRepository.findByUsername(username);
	if(user != null) 
	{
		return user;
	}
	throw new Exception("User "+ username +" Not Found!");
}

/** Getting A Specific User By User ID
 * 
 * @param userId
 * @return
 */
public User getUserById(long userId)   
{  
	return userRepository.findById(userId).get();  
}  

/** Saving A Specific User
 * 
 * @param user
 * @return
 */
public User saveOrUpdate(User user)   
{  
	return userRepository.save(user);  
}  

/** Deleting A Specific User By User ID
 * 
 * @param userId
 */
public void softDelete(long userId)   
{  
	userRepository.softDelete(userId);  
}  

/** Updating A Specific User
 * 
 * @param user
 */
public void update(User user)   
{  
	userRepository.save(user);  
}

}