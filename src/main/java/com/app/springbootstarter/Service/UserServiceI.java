package com.infy.springbootstarter.Service;

import java.util.List;

import com.infy.springbootstarter.ExceptionHandler.NotFoundException;
import com.infy.springbootstarter.Models.User;

public interface UserServiceI  {
	
	
	
	
	
	public String deleteUser(String id)  throws NotFoundException ;
	
	public String updateUser(User user) throws NotFoundException;
	
	public User searchUser(String id) throws NotFoundException;
	
	public List<User> getAllUsers() throws NotFoundException;
	
	public User userLogin(User loggingUser)  throws NotFoundException;
	
	public User userSignup(User newUser)  throws NotFoundException;
	
	
	
	

}
