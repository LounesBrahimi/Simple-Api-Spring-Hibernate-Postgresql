package com.simpleapi.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleapi.api.dao.UserDAO;
import com.simpleapi.api.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
    public List<User> getUsers() {
        return userDAO.findAll();
    }
    
    public User saveUser(User user) {
        User savedUser = userDAO.save(user);
        return savedUser;
    }
}
