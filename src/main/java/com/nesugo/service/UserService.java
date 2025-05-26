package com.nesugo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nesugo.model.UserEntity;
import com.nesugo.repository.UserRepository;
import com.nesugo.util.JwtUtil;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	JwtUtil jwtUtil;

	public boolean doRegistUser(String userName, String email) {
		if (userRepository.findByUserName(userName).isPresent()) {
			return false;
		}

		UserEntity user = new UserEntity();
		user.setUserName(userName);
		if (email != null && !email.trim().isEmpty()) {
			user.setEmail(email);
		}
		userRepository.save(user);
		return true;
	}
	
//	public boolean doLogin(String userName) {
//		if (userRepository.findByUserName(userName).isPresent()) {			
//			return true;
//		}
//		return false;
//	}
	
	public Optional<String> doLogin(String userName) {
		Optional<UserEntity> user = userRepository.findByUserName(userName);
		if (user.isPresent()) {
			String token = jwtUtil.generateToken(user.get().getUserName(), user.get().getUserId());
			return Optional.of(token);
		}
		return Optional.empty();
	}
}
