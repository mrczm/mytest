package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Users;

public interface UserService {

	public void register(Users user);

	public Users findUserByName(String username);

}
