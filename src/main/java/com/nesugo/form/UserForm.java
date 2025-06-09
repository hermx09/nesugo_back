package com.nesugo.form;

import lombok.Data;

@Data
public class UserForm {

	private String userName;
	private String email;
	private String password;
	private Boolean isEnableAuth;
}
