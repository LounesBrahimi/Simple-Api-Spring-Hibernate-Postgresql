package com.webapphibernate.webapphibernate;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.webapphibernate.webapphibernate")
public class CustomProperties {
	
    private String apiUrl;
    
    public String getApiUrl() {
    	return apiUrl;
    }
    
    public void setApiUrl(String apiUrl) {
    	this.apiUrl = apiUrl;
    }
}