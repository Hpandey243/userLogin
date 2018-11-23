package com.infy.springbootstarter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.springbootstarter.ExceptionHandler.NotFoundException;
import com.infy.springbootstarter.Models.User;
import com.infy.springbootstarter.Service.UserServiceI;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserServiceI userservice;

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome user";

	}

	@PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> userSignup(@RequestBody User user) throws NotFoundException {
		User userLogged = userservice.userSignup(user);

		return new ResponseEntity<User>(userLogged, HttpStatus.CREATED);

	}

	@PostMapping(value = "/userLogin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> userLogin(@RequestBody User user) throws NotFoundException {
		User userLogged = userservice.userLogin(user);
		return new ResponseEntity<User>(userLogged, HttpStatus.CREATED);

	}

	@GetMapping(value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> retrieveUser(@PathVariable String id) throws NotFoundException {

		User user = userservice.searchUser(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> retrieveAllUsers() throws NotFoundException {
		return userservice.getAllUsers();

	}

	@PutMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateUser(@RequestBody User user) throws NotFoundException {
		String message = userservice.updateUser(user);
		return new ResponseEntity<Object>(message + user.getUserId(), HttpStatus.OK);

	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) throws NotFoundException {
		String message = userservice.deleteUser(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

}
