package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.po.User;
import com.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(userMapper);
	}
}
