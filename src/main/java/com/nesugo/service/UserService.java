package com.nesugo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public boolean doRegistUser(String userName, String password) {
		if (userRepository.findByUserName(userName).isPresent()) {
			return false;
		}

		UserEntity user = new UserEntity();
		user.setUserName(userName);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		return true;
	}

//	public boolean doRegistUser(String userName) {
//		if (userRepository.findByUserName(userName).isPresent()) {
//			return false;
//		}
//
//		UserEntity user = new UserEntity();
//		user.setUserName(userName);
////		user.setPassword(passwordEncoder.encode(password));
//		userRepository.save(user);
//		return true;
//	}

	public Optional<String> doLogin(String userName, String password, Boolean isEnableAuth) {
		Optional<UserEntity> user = userRepository.findByUserName(userName);
		if (user.isPresent() && (passwordEncoder.matches(password, user.get().getPassword()) || isEnableAuth)) {
			String token = jwtUtil.generateToken(user.get().getUserName(), user.get().getUserId());
			return Optional.of(token);
		}
		return Optional.empty();
	}

	public Optional<UserEntity> doExistUser(String userName) {
		return userRepository.findByUserName(userName);
	}
//	public Optional<String> doLogin(String userName) {
//		Optional<UserEntity> user = userRepository.findByUserName(userName);
//		if (user.isPresent()) {
//			String token = jwtUtil.generateToken(user.get().getUserName(), user.get().getUserId());
//			return Optional.of(token);
//		}
//		return Optional.empty();
//	}

}
