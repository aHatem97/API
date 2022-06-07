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

import com.example.api.entities.User;
import com.example.api.services.UserService;

@RestController
@RequestMapping(path = "/api/manage/user")
public class UserController 
{

@Autowired
UserService userService;

/** Creating A Get Mapping That Retrieves All The User Details From The Database
 * 
 * @return
 */
@GetMapping
public List<User> getAllUsers()
{
    return userService.getAllUsers();
}

/** Creating A Get Mapping That Retrieves The Details Of A Specific User
 *   
 * @param userId
 * @return
 */
@GetMapping("/id/{userId}")  
private User getUser(@PathVariable("userId") long userId)   
{  
	return userService.getUserById(userId);  
}  

/** Creating A Get Mapping That Retrieves The Details Of A Specific User with username
 *   
 * @param username
 * @return
 * @throws Exception 
 */
@GetMapping("/name/{username}")  
private User getUserByUsername(@PathVariable("username") String username) throws Exception   
{  
	return userService.getUserByUsername(username);  
}  

/** Creating A Delete Mapping That Deletes A Specified User 
 *  
 * @param userID
 */
@DeleteMapping("/delete/{userId}")  
private void softDeleteUser(@PathVariable("userId") long userId)   
{  
	userService.softDelete(userId);  
}  

/** Creating Post Mapping That Saves The User Details In The Database 
 *  
 * @param user
 * @return
 * @throws Exception
 */
@PostMapping 
private long saveUser(@RequestBody User user) throws Exception   
{  
		User u = userService.saveOrUpdate(user);
		return u.getUserId();
}

}