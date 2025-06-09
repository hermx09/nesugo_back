package com.nesugo.controller;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nesugo.form.UserForm;
import com.nesugo.service.UserService;


@RestController
@RequestMapping("/nesugo")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/registUser")
	public ResponseEntity<?> registUser(@RequestBody UserForm userForm) {
		if(!userService.doRegistUser(userForm.getUserName(), userForm.getPassword())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("ユーザーネームが重複しています");
		}
		Optional<String> tokenOpt = userService.doLogin(userForm.getUserName(), userForm.getPassword(), userForm.getIsEnableAuth());
			return ResponseEntity.ok().body(Collections.singletonMap("token", tokenOpt.get()));
	}
	
//	@PostMapping("/registUser")
//	public ResponseEntity<?> registUser(@RequestBody UserForm userForm) {
//		if(!userService.doRegistUser(userForm.getUserName())) {
//			return ResponseEntity.status(HttpStatus.CONFLICT).body("ユーザーネームが重複しています");
//		}
//		Optional<String> tokenOpt = userService.doLogin(userForm.getUserName());
//			return ResponseEntity.ok().body(Collections.singletonMap("token", tokenOpt.get()));
//	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserForm userForm) {
		Optional<String> tokenOpt = userService.doLogin(userForm.getUserName(), userForm.getPassword(), userForm.getIsEnableAuth());
		if (tokenOpt.isPresent()) {
			return ResponseEntity.ok().body(Collections.singletonMap("token", tokenOpt.get()));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ユーザー名が一致しません");
		}
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<?> loginUser(@RequestBody UserForm userForm) {
//		Optional<String> tokenOpt = userService.doLogin(userForm.getUserName());
//		System.out.println(tokenOpt);
//		if (tokenOpt.isPresent()) {
//			return ResponseEntity.ok().body(Collections.singletonMap("token", tokenOpt.get()));
//		} else {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ユーザー名が一致しません");
//		}
//	}
	
	@PostMapping("/getUser")
	public ResponseEntity<String> existUser(@RequestBody UserForm userForm){
		if(userService.doExistUser(userForm.getUserName()).isPresent()) {
			return ResponseEntity.ok().body(userForm.getUserName());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ユーザーがみつかりません");
	}
}
