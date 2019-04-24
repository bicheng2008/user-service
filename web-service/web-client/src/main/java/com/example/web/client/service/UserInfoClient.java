package com.example.web.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("userservice")
@RequestMapping(value = "/userinfo")
public interface UserInfoClient {

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
	String findByUserId(@RequestParam("userId") String userId);
}
