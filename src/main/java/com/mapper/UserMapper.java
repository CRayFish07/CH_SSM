package com.mapper;

import org.springframework.stereotype.Repository;

import com.po.User;

@Repository
public interface UserMapper extends BaseMapper<User, String> {

}
