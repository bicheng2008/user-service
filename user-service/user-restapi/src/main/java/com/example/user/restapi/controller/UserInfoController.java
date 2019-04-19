package com.example.user.restapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.user.domain.entity.UserInfo;
import com.example.user.domain.service.UserInfoService;
import com.example.user.object.UserInfoQo;
import com.google.gson.Gson;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "/{userId}")
	public CompletableFuture<String> fnidByUserId(@PathVariable String userId) {
		return CompletableFuture.supplyAsync(() -> {
			List<UserInfoQo> userInfoQoList = new ArrayList<>();
			List<UserInfo> userInfoList = userInfoService.findByUserId(userId);
			for(UserInfo userInfo : userInfoList) {
				UserInfoQo userInfoQo = new UserInfoQo();
				userInfoQo.setUserId(userInfo.getUserId());
				userInfoQo.setUserName(userInfo.getUserName());
				userInfoQoList.add(userInfoQo);
			}
			return new Gson().toJson(userInfoQoList);
		});
	}
}
