package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.po.User;
import com.service.UserService;
import com.util.ResultMap;

@Controller
@RequestMapping("user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("test") // all
	@ResponseBody
	public ResultMap demoTest(){
		ResultMap rs = new ResultMap();
		User user = new User();
		user.setName("陈旭健");
		user.setPassword("cxj");
		userService.add(user);
		return rs.success().data(user);
	}
}
