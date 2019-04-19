package com.example.web.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.web.client.service.UserInfoFuture;
import com.example.web.object.UserInfoVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RestController
@RequestMapping(value="/user")
public class UserInfoController {

	@Autowired
	private UserInfoFuture userInfoFuture;
	
	@RequestMapping(value = "/index")
	public ModelAndView index(ModelMap model) throws Exception {
		return new ModelAndView("html/index");
	}
	
	@RequestMapping(value = "/findUserName/{userId}")
	public CompletableFuture<String> findUserName(UserInfoVo user, @PathVariable String userId) {
		return userInfoFuture.findByUserId(userId).thenApply(json -> {
			if (!json.equals("-1")) {
				List<UserInfoVo> userInfoVoList = new Gson().fromJson(json, new TypeToken<List<UserInfoVo>>() {
				}.getType());
				if (userInfoVoList.size() > 0) {
					System.out.println(new Gson().toJson(userInfoVoList.get(0)));
					return new Gson().toJson(userInfoVoList.get(0));
				} else {
					return "0";
				}
			} else {
				return "-1";
			}
		});
	}
}
