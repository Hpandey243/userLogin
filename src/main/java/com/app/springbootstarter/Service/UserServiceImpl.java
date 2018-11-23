package com.infy.springbootstarter.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.springbootstarter.ExceptionHandler.NotFoundException;
import com.infy.springbootstarter.Models.User;
import com.infy.springbootstarter.UserDAO.userDAOI;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	userDAOI userDao;

	

	@Override
	public String deleteUser(String id) throws NotFoundException {

		Optional<User> optionalUser = Optional.ofNullable(userDao.findOne(id));
		if (optionalUser.isPresent()) {
			userDao.delete(id);
			return optionalUser.get().getUserName() + "successfully deleted";

		}

		throw new NotFoundException("User " + id + " not Found");
	}

	@Override
	public String updateUser(User user) throws NotFoundException {

		
		Optional<User> optionalUser = Optional.ofNullable(userDao.findOne(user.getUserId()));
		if (optionalUser.isPresent()) {
			userDao.save(user);
			return optionalUser.get().getUserName() + "successfully saved";

		}

		throw new NotFoundException("User " + user.getUserName() + " not Found");

	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();

	}

	@Override
	public User searchUser(String userId) throws NotFoundException {

		Optional<User> optionalUser = Optional.ofNullable(userDao.findOne(userId));
		if (optionalUser.isPresent()) {
			return userDao.findOne(userId);
		}
		throw new NotFoundException("User " + userId + " not Found");

	}

	@Override
	public User userLogin(User loggingUser) throws NotFoundException {
		Optional<User> userData = Optional.ofNullable(userDao.findOne(loggingUser.getUserId()));
		if (userData.isPresent()) {
			if (userData.get().getPassword().equals(loggingUser.getPassword())) {
				return userData.get();
			} else {
				throw new NotFoundException("Incorrect Password ");

			}
		}
		throw new NotFoundException("User  not Found please Sign Up");
	}

	@Override
	public User userSignup(User newUser) throws NotFoundException {

		newUser.setUserId(generateUserId(newUser));
		Optional<User> userData = Optional.ofNullable(userDao.findOne(newUser.getUserId()));
		if (userData.isPresent()) {
			throw new NotFoundException("User with same name and contact no.  already present please login");

		} else {
			User x = userDao.save(newUser);
			return x;
		}
		 
	}

	public String generateUserId(User user) {
		String userId = user.getUserName().substring(0, 4) + user.getPhoneNumber().toString().substring(0, 3);
		return userId;

	}

}
