package com.example.web.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoClient userInfoClient;

	@HystrixCommand(fallbackMethod = "findByUserIdFallback")
	public String findByUserId(String userId) {
		return userInfoClient.findByUserId(userId);
	}

	private String findByUserIdFallback(String userId) {
		return "-1"; 
	}
}
