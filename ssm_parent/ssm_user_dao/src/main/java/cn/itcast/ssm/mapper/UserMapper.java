package cn.itcast.ssm.mapper;

import cn.itcast.ssm.domain.Users;

public interface UserMapper {

	public void register(Users user);

	public Users findUserByName(String username);

}
