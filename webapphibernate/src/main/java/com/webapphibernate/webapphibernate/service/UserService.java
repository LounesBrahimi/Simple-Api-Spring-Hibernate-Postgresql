package com.webapphibernate.webapphibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapphibernate.webapphibernate.dao.UserProxy;
import com.webapphibernate.webapphibernate.entity.User;

@Service
public class UserService {
	
	@Autowired
    private UserProxy userProxy;

    public Iterable<User> getUsers() {
        return userProxy.getUsers();
    }
    
    public User registreUsers(User user) {
    	User savedUser = null;
        if(user.getId() == null) {
        	savedUser = userProxy.registreUser(user);
        }
        return savedUser;
    }
    
    public User getUser(final Long long1) {
		return this.userProxy.getUser(long1);
	}
}
