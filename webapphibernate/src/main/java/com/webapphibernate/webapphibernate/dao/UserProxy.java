package com.webapphibernate.webapphibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.webapphibernate.webapphibernate.CustomProperties;
import com.webapphibernate.webapphibernate.entity.User;


@Component
public class UserProxy {

	@Autowired
    private CustomProperties props;
	
	public Iterable<User> getUsers() {
		String baseApiUrl = props.getApiUrl();
        String getUsersUrl = baseApiUrl + "/users";
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> response = restTemplate.exchange(
        		getUsersUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<User>>() {}
			);
        return response.getBody();
	}
	
	public User getUser(Long long1) {
		String baseApiUrl = props.getApiUrl();
		String getUserUrl = baseApiUrl + "/user/" + long1;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> response = restTemplate.exchange(
				getUserUrl, 
				HttpMethod.GET, 
				null,
				User.class
			);
		
		return response.getBody();
	}
	
	public User registreUser(User user) {
		String baseApiUrl = props.getApiUrl();
	    String createUserUrl = baseApiUrl + "/user";
	    
	    RestTemplate restTemplate = new RestTemplate();
	    HttpEntity<User> request = new HttpEntity<User>(user);
	    ResponseEntity<User> response = restTemplate.exchange(
	            createUserUrl,
	            HttpMethod.POST,
	            request,
	            User.class);
	    return response.getBody();
	}
}
