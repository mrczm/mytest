package cn.itcast.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.ssm.domain.Users;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void register(Users user) {
		userMapper.register(user);
	}

	@Override
	public Users findUserByName(String username) {
		return userMapper.findUserByName(username);
	}

}
