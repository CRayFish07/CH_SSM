package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.User;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("getUser")
	public String getUser(){
		User user = new User();
		user.setName("cxj");
		user.setPassword("cxj123");
		return user.toString(); 
	}
}
