package com.example.user.domain.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.user.domain.entity.UserInfo;
import com.example.user.domain.repository.UserInfoRepository;

@Service
@Transactional
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	public List<UserInfo> findByUserId(String userId) {
		return userInfoRepository.findByUserId(userId);
	}
}
