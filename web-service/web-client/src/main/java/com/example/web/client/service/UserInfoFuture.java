package com.example.web.client.service;

import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserInfoFuture {

	@Autowired
	private UserInfoService userInfoService;

	@Async
	public CompletableFuture<String> findByUserId(String userId) {
		return CompletableFuture.supplyAsync(() -> {
			return userInfoService.findByUserId(userId);
		});
	}
}
