package com.infy.springbootstarter.UserDAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.infy.springbootstarter.Models.User;

@Repository
public interface userDAOI extends MongoRepository<User, String>{

}